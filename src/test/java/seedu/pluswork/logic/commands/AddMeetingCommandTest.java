package seedu.pluswork.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.pluswork.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.pluswork.commons.core.index.Index;

public class AddMeetingCommandTest {

    @Test
    public void constructor_nullMeeting_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddMeetingCommand(null));
    }

//    @Test
//    public void execute_calendarAcceptedByModel_addSuccessful() throws Exception {
//        ModelStubAcceptingTaskAdded modelStub = new ModelStubAcceptingTaskAdded();
//        Task validTask = new TaskBuilder().build();
//
//        CommandResult commandResult = new AddTaskCommand(validTask).execute(modelStub);
//
//        //Commented out for assertion error
//        //assertEquals(String.format(AddTaskCommand.MESSAGE_SUCCESS, validTask), commandResult.getFeedbackToUser());
//        assertEquals(Arrays.asList(validTask), modelStub.tasksAdded);
//    }
//
//    @Test
//    public void execute_duplicateTask_throwsCommandException() {
//        Task validTask = new TaskBuilder().build();
//        AddTaskCommand addTaskCommand = new AddTaskCommand(validTask);
//        ModelStub modelStub = new ModelStubWithTask(validTask);
//
//        assertThrows(CommandException.class, AddTaskCommand.MESSAGE_DUPLICATE_TASK, () ->
//                addTaskCommand.execute(modelStub));
//    }

    @Test
    public void equals() {
        Index testIndex1 = new Index(1);
        Index testIndex2 = new Index(200000000);
        AddMeetingCommand addMeetingCommand1 = new AddMeetingCommand(testIndex1);
        AddMeetingCommand addMeetingCommand2 = new AddMeetingCommand(testIndex2);

        // same object -> returns true
        assertTrue(addMeetingCommand1.equals(addMeetingCommand1));

        // same values -> returns true
        AddMeetingCommand addMeetingCommand1Copy = new AddMeetingCommand(testIndex1);
        assertTrue(addMeetingCommand1.equals(addMeetingCommand1Copy));

        // different types -> returns false
        assertFalse(addMeetingCommand2.equals(1));

        // null -> returns false
        assertFalse(addMeetingCommand2.equals(null));

        // different task -> returns false
        assertFalse(addMeetingCommand1.equals(addMeetingCommand2));
    }

//    /**
//     * A default model stub that have all of the methods failing.
//     */
//    private class ModelStub implements Model {
//        @Override
//        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ReadOnlyUserPrefs getUserPrefs() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public GuiSettings getGuiSettings() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setGuiSettings(GuiSettings guiSettings) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public Path getProjectDashboardFilePath() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setProjectDashboardFilePath(Path projectDashboardFilePath) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void addTask(Task task) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setProjectDashboard(ReadOnlyProjectDashboard newData) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ReadOnlyProjectDashboard getProjectDashboard() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public boolean hasTask(Task task) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void deleteTask(Task target) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setTask(Task target, Task editedTask) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ObservableList<Task> getFilteredTaskListByDeadline() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ObservableList<Task> getFilteredTaskListNotStarted() {
//            throw new AssertionError("This method should not be called");
//        }
//
//        @Override
//        public ObservableList<Task> getFilteredTaskListDoing() {
//            throw new AssertionError("This method should not be called");
//        }
//
//        @Override
//        public ObservableList<Task> getFilteredTaskListDone() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ObservableList<Task> getFilteredTasksList() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void updateFilteredTasksList(Predicate<Task> predicate) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void addMember(Member member) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public boolean hasMember(Member member) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public boolean hasMemberId(MemberId memId) {
//            return false;
//        }
//
//        @Override
//        public void deleteMember(Member target) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setMember(Member target, Member editedMember) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public int getMembersLength() {
//            return 0;
//        }
//
//        @Override
//        public ObservableList<Member> getFilteredMembersList() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void updateFilteredMembersList(Predicate<Member> predicate) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public int getTasksLength() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ObservableList<Inventory> getFilteredInventoriesList() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void updateFilteredInventoriesList(Predicate<Inventory> predicate) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void addInventory(Inventory inventory) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public boolean hasInventory(Inventory inventory) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void deleteInventory(Inventory target) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setInventory(Inventory target, Inventory editedInventory) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void addMapping(Mapping mapping) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void deleteMapping(Mapping mapping) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public boolean hasMapping(Mapping mapping) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ObservableList<Mapping> getFilteredMappingsList() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void updateFilteredMappingsList(Predicate<Mapping> predicate) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public Statistics getStatistics() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setStatistics(Statistics newStats) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public UserSettings getUserSettings() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public Path getUserSettingsFilePath() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public Theme getCurrentTheme() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void setCurrentTheme(Theme newTheme) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ClockFormat getCurrentClockFormat() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ObservableList<TasMemMapping> getFilteredTasMemMappingsList() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//
//        public void setClockFormat(ClockFormat newClockFormat) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void addCalendar(CalendarWrapper calendar) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void deleteCalendar(CalendarWrapper calendar) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public boolean hasCalendar(CalendarWrapper calendar) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ObservableList<CalendarWrapper> getFilteredCalendarList() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void undo() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void redo() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public boolean canUndo() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public boolean canRedo() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ObservableList<InvMemMapping> getFilteredInvMemMappingsList() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void addMeeting(Meeting meeting) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void deleteMeeting(Meeting meeting) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public boolean hasMeeting(Meeting meeting) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public ObservableList<Meeting> getFilteredMeetingList() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void updateFilteredMeetingsList(Predicate<Meeting> predicate) {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public MeetingQuery getMeetingQuery() {
//            throw new AssertionError("This method should not be called.");
//        }
//
//        @Override
//        public void findMeetingTime(LocalDateTime startDate, LocalDateTime endDate, Duration meetingDuration) {
//            throw new AssertionError("This method should not be called.");
//        }
//    }
//
//    /**
//     * A Model stub that contains a single task.
//     */
//    private class ModelStubWithTask extends ModelStub {
//        private final Task task;
//
//        ModelStubWithTask(Task task) {
//            requireNonNull(task);
//            this.task = task;
//        }
//
//        @Override
//        public boolean hasTask(Task task) {
//            requireNonNull(task);
//            return this.task.isSameTask(task);
//        }
//    }
//
//    /**
//     * A Model stub that always accept the task being added.
//     */
//    private class ModelStubAcceptingTaskAdded extends ModelStub {
//        final ArrayList<Task> tasksAdded = new ArrayList<>();
//
//        @Override
//        public boolean hasTask(Task task) {
//            requireNonNull(task);
//            return tasksAdded.stream().anyMatch(task::isSameTask);
//        }
//
//        @Override
//        public void addTask(Task task) {
//            requireNonNull(task);
//            tasksAdded.add(task);
//        }
//
//        @Override
//        public ReadOnlyProjectDashboard getProjectDashboard() {
//            return new ProjectDashboard();
//        }
//    }
//
}