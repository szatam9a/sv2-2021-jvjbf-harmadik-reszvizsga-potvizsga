package examinformation;

public class ExamResult {
    private int theory;
    private int practice;
    private double theoryInPercent;
    private double practiceInPercent;
    private boolean successful;

    public ExamResult(int theory, int practice) {
        this.theory = theory;
        this.practice = practice;
    }

    public int getTheory() {
        return theory;
    }

    public int getPractice() {
        return practice;
    }

    public double getTheoryInPercent() {
        return theoryInPercent;
    }

    public double getPracticeInPercent() {
        return practiceInPercent;
    }

    public void setTheoryInPercent(int theoryInPercent) {
        this.theoryInPercent = theoryInPercent;
    }

    public void setPracticeInPercent(int practiceInPercent) {
        this.practiceInPercent = practiceInPercent;
    }

    public int totalPoints() {
        return practice + theory;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }
}
