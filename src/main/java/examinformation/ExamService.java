package examinformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ExamService {
    private int theoryMax;
    private int practiceMax;
    private Map<String, ExamResult> results = new TreeMap<>();

    public void readFromFIle(Path path) {
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            readMinAndMAx(line = br.readLine());
            while ((line = br.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException io) {
            throw new IllegalArgumentException("Cannot read file: " + path);
        }
    }

    private void processLine(String line) {
        String[] tmp = line.split(";");
        String name = tmp[0];
        tmp = tmp[1].split(" ");
        ExamResult toMap = new ExamResult(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
        toMap.setTheoryInPercent((int)(toMap.getTheory()*100.0 / theoryMax));
        toMap.setPracticeInPercent((int)(toMap.getPractice()*100.0) / practiceMax);
        if (toMap.getPracticeInPercent() < 51 || toMap.getTheoryInPercent() < 51)
            toMap.setSuccessful(false);
        else toMap.setSuccessful(true);
        results.put(name, toMap);
    }


    private void readMinAndMAx(String s) {
        Scanner sc = new Scanner(s);
        sc.useDelimiter(" ");
        theoryMax = sc.nextInt();
        practiceMax = sc.nextInt();
    }

    public int getTheoryMax() {
        return theoryMax;
    }

    public int getPracticeMax() {
        return practiceMax;
    }

    public Map<String, ExamResult> getResults() {
        return results;
    }

    public List<String> findPeopleFailed() {
        return results.entrySet().stream().
                filter(e -> e.getValue().getPracticeInPercent() <= 51 || e.getValue().getTheoryInPercent() <= 51).map(e -> e.getKey()).toList();
    }

    public String findBestPerson() {
        return results.entrySet().stream().filter(e -> e.getValue().isSuccessful()).sorted((e1, e2) -> e2.getValue().totalPoints() - e1.getValue().totalPoints()).findFirst().get().getKey();
    }
}
