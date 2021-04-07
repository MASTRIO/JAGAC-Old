// Package
package me.MASTRIO.JustAnotherGameAboutCheese;

// Import
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Create GUI Class
public class UI implements ActionListener {

  // Variables
  static String command;
  static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
  static LocalDateTime now = LocalDateTime.now();

  // Create UI variables
  static JTextArea outputPane;
  static JTextField commandInputBox;
  static JButton runCommandButton;

  // Make UI Method
  public void makeUI() {

    // Create base UI
    JPanel panel = new JPanel();
    JFrame frame = new JFrame(Main.title);
    frame.setSize(500, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);
    panel.setLayout(null);

    // Make UI Objects
    // Command Output box
    outputPane = new JTextArea();
    outputPane.setBounds(5, 5, 475, 505);
    panel.add(outputPane);

    // Command Input box
    commandInputBox = new JTextField();
    commandInputBox.setBounds(5, 517, 410, 40);
    panel.add(commandInputBox);

    // Execute Command Button
    runCommandButton = new JButton("Run");
    runCommandButton.setBounds(417, 516, 63, 40);
    runCommandButton.addActionListener(new UI());
    panel.add(runCommandButton);

    // Make UI Visible
    frame.setVisible(true);

  }

  @Override
  public void actionPerformed(ActionEvent e) {

    // Variables
    command = commandInputBox.getText();

    // Compile Command
    CommandCompiler.compileCommand();

    // Reset Input
    commandInputBox.setText("");

  }

  // Output Text Method
  public static void outputText(String consoleMessage, String output) {

    LocalDateTime now = LocalDateTime.now();

    UI.outputPane.setText(CommandCompiler.border + "\n" + output + "\n" + CommandCompiler.border);

    System.out.println("[" + (dtf.format(now)) + " | CommandOutput]@>>> " + consoleMessage);


  }

}