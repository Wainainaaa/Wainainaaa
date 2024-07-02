package com.taskmanager;

import javax.management.remote.JMXServiceURL;
import javax.swing.*;
import java.awt.*;

public class TaskManagerFrame extends JFrame {
    private TaskPanel taskPanel;

    public TaskManagerFrame() {
        setTitle("Task Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);

        initComponents();
    }

    public void initComponents() {
        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");

        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // create the menu content
        taskPanel = new TaskPanel(this);
        add(taskPanel, BorderLayout.CENTER);

        // create a toolbar
        JToolBar toolBar = new JToolBar();
        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(e -> showAddTaskDialogue());
        toolBar.add(addButton);

        add(toolBar, BorderLayout.NORTH);
    }
    public void showAddTaskDialogue() {
        AddTaskDialogue dialogue = new AddTaskDialogue(this);
        dialogue.setVisible(true);
        if (dialogue.getTask() != null) {
            taskPanel.addTask(dialogue.getTask());
        }

    }
}
