package tech.sketch.command;


import java.util.Optional;

/**
 * Encapsulates the status of a a command execution result. Used to propagate messages an
 * actions to the console
 */
public class CommandResult {
    public enum CommandStatus {
        SUCCESS,
        ERROR,
        EXIT,
        UNKNOWN
    }

    private final CommandStatus status;
    private final Optional<String> message;

    private CommandResult(CommandStatus status, String message) {
        this.status = status;
        this.message = Optional.ofNullable(message);
    }


    private CommandResult(CommandStatus status) {
        this(status, null);
    }

    public static CommandResult success(String message) {
        return new CommandResult(CommandStatus.SUCCESS, message);
    }

    public static CommandResult success() {
        return success(null);
    }

    public static CommandResult errorCommand(String message) {
        return new CommandResult(CommandStatus.ERROR, message);
    }

    public static CommandResult exitCommand() {
        return new CommandResult(CommandStatus.EXIT);
    }

    public static CommandResult unknownCommand(String command) {
        return new CommandResult(CommandStatus.UNKNOWN, String.format("Unknown command: %s", command));
    }


    public CommandStatus getStatus() {
        return status;
    }

    public Optional<String> getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return true;
    }

    @Override
    public String toString() {
        return "CommandResult{" +
                "status=" + status +
                ", message=" + (message.isPresent() ? message.get() : "") +
                '}';
    }
}
