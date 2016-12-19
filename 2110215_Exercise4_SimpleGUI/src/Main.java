import javax.swing.*;
import javax.swing.text.DefaultCaret;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  public static Color NorthDefaultColor = new Color(84, 36, 55);
  public static JPanel north = new JPanel();

  public static void main(String[] args) {

    JFrame frame = new JFrame();
    frame.setSize(700, 350);
    frame.setResizable(false);
    frame.getContentPane().setLayout(new BorderLayout());

    //===============================NORTH PANEL======================================//	

    JLabel northText = new JLabel("5731015621 Jirapat Atiwattanachai");

    northText.setFont(new Font("Tahoma", Font.BOLD + Font.ITALIC, 30));
    northText.setForeground(Color.WHITE);
    north.setLayout(new GridBagLayout());
    north.add(northText);
    north.setBackground(new Color(84, 36, 55));
    north.setPreferredSize(new Dimension(700, 100));
    north.addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseEntered(MouseEvent arg0) {
        north.setBackground(new Color(236, 208, 120));
        northText.setForeground(Color.DARK_GRAY);
      }

      @Override
      public void mouseExited(MouseEvent arg0) {
        north.setBackground(NorthDefaultColor);
        northText.setForeground(Color.WHITE);
      }

      @Override
      public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
      }

    });
    frame.add(north, BorderLayout.NORTH);



    //===============================SOUTH PANEL======================================//	
    JPanel south = new JPanel();
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);
    DefaultCaret caret = (DefaultCaret) textArea.getCaret();
    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    textArea.setEditable(false);
    south.setLayout(new GridLayout(1, 1));
    south.setPreferredSize(new Dimension(700, 100));
    south.add(scrollPane);
    frame.add(south, BorderLayout.SOUTH);
    String output = "Text:\n";
    
    Scanner sn;
    try {
      sn = new Scanner(new File(".\\src\\ExampleFile1.txt"));
      while (sn.hasNext()) {
        output += sn.nextLine() + "\n";
      }
      textArea.setText(output);

    } catch (FileNotFoundException e1) {
      JOptionPane.showMessageDialog(frame, "File is not found");
      e1.printStackTrace();
    }

    //===============================WEST PANEL======================================//
    JPanel west = new JPanel();
    west.setPreferredSize(new Dimension(150, 150));
    west.setLayout(new GridLayout(2, 2));
    JButton topLeftButton = new JButton();
    topLeftButton.setBackground(new Color(84, 36, 55));
    topLeftButton.addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) {
        NorthDefaultColor = new Color(84, 36, 55);
        north.setBackground(new Color(84, 36, 55));
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
      }

    });
    JButton topRightButton = new JButton();
    topRightButton.setBackground(new Color(96, 72, 72));
    topRightButton.addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) {
        NorthDefaultColor = new Color(96, 72, 72);
        north.setBackground(new Color(96, 72, 72));
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
      }

    });
    JButton botLeftButton = new JButton();
    botLeftButton.setBackground(new Color(47, 6, 24));
    botLeftButton.addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) {
        NorthDefaultColor = new Color(47, 6, 24);
        north.setBackground(new Color(47, 6, 24));
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
      }

    });
    JButton botRightButton = new JButton();
    botRightButton.setBackground(new Color(98, 40, 36));
    botRightButton.addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) {
        NorthDefaultColor = new Color(98, 40, 36);
        north.setBackground(new Color(98, 40, 36));
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
      }

    });
    west.add(topLeftButton);
    west.add(topRightButton);
    west.add(botLeftButton);
    west.add(botRightButton);
    frame.add(west, BorderLayout.WEST);

    
    //===============================EAST PANEL======================================//	
    JPanel east = new JPanel();
    JButton chooseFileButton = new JButton("Choose File");
    east.setBackground(new Color(192, 216, 96));
    east.setPreferredSize(new Dimension(150, 150));
    east.add(chooseFileButton);
    chooseFileButton.addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent arg0) {
        String fileName;
        String output = "Text:\n";
        FileDialog fd = new FileDialog(frame, "Open");
        fd.setVisible(true);
        fileName = fd.getFile();
        if (fileName != null) {
          Scanner sn;
          try {
            sn = new Scanner(new File(fileName));
            while (sn.hasNext()) {
              output += sn.nextLine() + "\n";
            }
            textArea.setText(output);
            sn.close();
          } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      }

      @Override
      public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub
      }

    });
    frame.add(east, BorderLayout.EAST);

    
    //===============================CENTER PANEL======================================//	
    JPanel center = new JPanel();
    JLabel firstNameLabel = new JLabel(" First Name");
    JLabel idLabel = new JLabel(" ID");
    JLabel lastNameLabel = new JLabel(" Last Name");
    JTextField firstNameField = new JTextField();
    JTextField lastNameField = new JTextField();
    JTextField idField = new JTextField();
    GridBagConstraints gBC = new GridBagConstraints();
    gBC.insets = new Insets(0, 0, 0, 0);
    center.setLayout(new GridBagLayout());

    gBC.anchor = GridBagConstraints.WEST;
    gBC.weightx = 10;
    gBC.weighty = 40;
    gBC.gridx = 0;
    gBC.gridy = 0;
    gBC.ipady = 40;
    idLabel.setForeground(Color.black);
    center.add(idLabel, gBC);

    gBC.gridx = 0;
    gBC.gridy = 1;
    center.add(firstNameLabel, gBC);

    gBC.gridx = 0;
    gBC.gridy = 2;
    center.add(lastNameLabel, gBC);

    gBC.weightx = 350;
    gBC.insets = new Insets(0, 0, 10, 0);
    gBC.fill = GridBagConstraints.HORIZONTAL;
    gBC.anchor = GridBagConstraints.WEST;
    gBC.gridx = 1;
    gBC.gridy = 0;
    center.add(idField, gBC);

    gBC.gridx = 1;
    gBC.gridy = 1;
    center.add(firstNameField, gBC);

    gBC.insets = new Insets(0, 0, 0, 0);
    gBC.gridx = 1;
    gBC.gridy = 2;
    center.add(lastNameField, gBC);

    JButton submitButton = new JButton("Submit");
    submitButton.addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) {
        String input = idField.getText();
        Boolean valid = true;
        if (input.length() != 10) {
          valid = false;
        }
        for (int i = 0; i < input.length(); i++) {
          if (input.charAt(i) < '0' || input.charAt(i) > '9') {
            valid = false;
          }
        }
        if (lastNameField.getText().length() < 1 || firstNameField.getText().length() < 1) {
          valid = false;
        }
        input = firstNameField.getText();
        for (int i = 0; i < input.length(); i++) {
          char c = input.charAt(i);
          if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
            valid = false;
          }
        }
        if (valid) {
          northText.setText(
              idField.getText() + " " + firstNameField.getText() + " " + lastNameField.getText() + " ");
        } else {
          JOptionPane.showMessageDialog(frame,
              "ID should contain 10 digits.\n" + "First name should contain only letters.(At least 1)\n"
                  + "Last name should contain only letters.(At least 1)");
        }
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
      }
    });
    gBC.ipady = 30;
    gBC.fill = 0;
    gBC.gridx = 1;
    gBC.gridy = 3;
    center.add(submitButton, gBC);
    center.setPreferredSize(new Dimension(400, 150));
    center.setBackground(new Color(240, 240, 216));
    frame.add(center, BorderLayout.CENTER);

    frame.pack();
    frame.setVisible(true);
  }
}