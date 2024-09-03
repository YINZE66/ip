package genji.task;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * A class that deals with list of tasks
 */
public class TaskList {
    private ArrayList<Task> taskList;

    /**
     * Constructor of task list class
     */
    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    /**
     * Adds task to the list
     * @param t Task to be added
     */
    public void add(Task t) {
        taskList.add(t);
    }

    /**
     * Deletes the specific task in the list
     * @param i Number concerning which task to be deleted
     */
    public void delete(int i) {
        taskList.remove(i);
    }

    /**
     * Gets the specific task in the list
     * @param i Number concerning which task to be getted
     * @return The requested task
     */
    public Task get(int i) {
        return taskList.get(i);
    }

    /**
     * Gets the whole task list
     * @return The task list
     */
    public ArrayList<Task> getList() {
        return taskList;
    }

    /**
     * Gets the size of the task list
     * @return Size of task list
     */
    public int size() {
        return taskList.size();
    }

    /**
     * Marks the specific task in task list
     * @param i Number concerning which task to be marked
     */
    public void mark(int i) {
        taskList.get(i).mark();
    }

    /**
     * Unmarks the specific task in task list
     * @param i Number concerning which task to be unmarked
     */
    public void unmark(int i) {
        taskList.get(i).unmark();
    }

    /**
     * Prints every task in the task list
     */
    public void showList() {
        if (taskList.size() == 0) {
            System.out.println("No task on list");
        } else {
            int index = 1;
            for (Task task : taskList) {
                System.out.println(String.format("%d. ", index) + task);
                index++;
            }
        }
    }

    /**
     * Prints tasks in a specific day
     * @param date The date concerning which tasks to be printed
     */
    public void checkDate(String date) {
        for (Task t : taskList) {
            if (t instanceof Deadline) {
                Deadline temp  = (Deadline) t;
                if (temp.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals(date)) {
                    System.out.println(t);
                }
            } else if (t instanceof Event) {
                Event temp = (Event) t;
                if (temp.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).equals(date)) {
                    System.out.println(t);
                }
            }
        }
    }
}
