package main;

public class GymIDGenerator implements IDGenerator {
    private final GymProgram gymDatabase;

    public GymIDGenerator(GymProgram gymDatabase) {
        this.gymDatabase = gymDatabase;
    }

    @Override
    public String generateID() {
        return "ID" + (gymDatabase.getMembersList().size() + 1);
    }
}