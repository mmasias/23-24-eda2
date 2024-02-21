

class IntakeNode {

    private Intake intake;
    private IntakeNode next;

    public IntakeNode(Intake intake) {
        this.intake = intake;
        this.next = null;
    }

    public Intake getIntake() {
        return intake;
    }

    public void setIntake(Intake intake) {
        this.intake = intake;
    }

    public IntakeNode getNext() {
        return next;
    }

    public void setNext(IntakeNode next) {
        this.next = next;
    }
}
