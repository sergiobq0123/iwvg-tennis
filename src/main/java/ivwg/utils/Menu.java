package ivwg.utils;

import java.util.ArrayList;

public abstract class Menu extends WithConsoleView {

    private static final String OPTION = "----- Choose one option -----";
    private static final String SELECTION = "----- Your Selection : ------";
    protected ArrayList<Command> commands;

    public Menu() {
        this.commands = new ArrayList<>();
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public void execute() {
        updateActiveCommands();
        ArrayList<Command> activeCommands = filterActiveCommands();

        int option;
        do {
            option = displayMenu(activeCommands);
        } while (!new ClosedInterval(0, commands.size()-1).includes(option));
        this.console.writeln(SELECTION);
        this.console.writeln(activeCommands.get(option).getTitle());
        activeCommands.get(option).execute();
    }

    private void updateActiveCommands() {
        for (Command command : this.commands) {
            command.updateIsActive();
        }
    }

    private ArrayList<Command> filterActiveCommands() {
        ArrayList<Command> activeCommands = new ArrayList<>();
        for (Command command : this.commands) {
            if (command.isActive()) {
                activeCommands.add(command);
            }
        }
        return activeCommands;
    }

    private int displayMenu(ArrayList<Command> activeCommands) {
        this.console.writeln();
        this.console.writeln(Menu.OPTION);
        for (int i = 0; i < activeCommands.size(); i++) {
            this.console.writeln((i + 1) + ") " + activeCommands.get(i).getTitle());
        }
        return this.console.readInt("") - 1;
    }

}