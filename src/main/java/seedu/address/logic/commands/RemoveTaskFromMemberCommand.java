package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEMBER_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK_INDEX;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.mapping.TasMemMapping;
import seedu.address.model.mapping.exceptions.MappingNotFoundException;
import seedu.address.model.member.Member;
import seedu.address.model.member.MemberId;
import seedu.address.model.task.Task;

/**
 * Removes a task that member was responsible for
 */
public class RemoveTaskFromMemberCommand extends Command {
    public static final String COMMAND_WORD = "fire-task";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Removes a task indicated "
            + "by the index number used in the displayed task list, to the member indicated "
            + "by the member ID. \n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_TASK_INDEX + "TASK_INDEX"
            + PREFIX_MEMBER_ID + "MEMBER_ID \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TASK_INDEX + " 2 "
            + PREFIX_MEMBER_ID + " JD";

    public static final String MESSAGE_REMOVE_TASK_SUCCESS = "Removes task for member: %1$s";
    public static final String MESSAGE_INVALID_TASK_ID = "This task does not exist under member.";

    private final Index taskId;
    private final MemberId memberId;

    /**
     * @param taskId of the task in the filtered task list to be added to member
     * @param memberId of the member involved
     */
    public RemoveTaskFromMemberCommand(Index taskId, MemberId memberId) {
        requireNonNull(memberId);

        this.taskId = taskId;
        this.memberId = memberId;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Task> lastShownTaskList = model.getFilteredTasksList();
        List<Member> lastShownMemberList = model.getFilteredMembersList();

        if (taskId.getZeroBased() >= lastShownTaskList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }

        boolean contains = false;
        Integer memberIndex = null;
        Member involvedMember = null;

        for (int i = 0; i < lastShownMemberList.size(); i++) {
            if (lastShownMemberList.get(i).getId().equals(memberId)) {
                contains = true;
                memberIndex = i;
                involvedMember = lastShownMemberList.get(i);
                break;
            }
        }

        if (!contains) {
            throw new CommandException(Messages.MESSAGE_INVALID_MEMBER_ID);
        }

        TasMemMapping mappingToRemove = createMapping(taskId.getZeroBased(), memberIndex);
        try {
            model.deleteMapping(mappingToRemove);
        } catch (MappingNotFoundException e) {
            throw new CommandException(MESSAGE_INVALID_TASK_ID);
        }
        return new CommandResult(String.format(MESSAGE_REMOVE_TASK_SUCCESS, involvedMember));
    }

    /**
     * Creates and returns a {@code Task} with the details of {@code taskToUpdate}
     * where TaskStatus is updated to 'In Progress".
     */
    private static TasMemMapping createMapping(int taskIndex, int memberIndex) {
        return new TasMemMapping(taskIndex, memberIndex);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RemoveTaskFromMemberCommand)) {
            return false;
        }

        // state check
        RemoveTaskFromMemberCommand e = (RemoveTaskFromMemberCommand) other;
        return memberId.equals(e.memberId)
                && taskId.equals(e.taskId);
    }
}