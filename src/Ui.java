
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Ui extends JFrame{
    private String Path;
 Ui(){
     setSize(500,400);
     JLabel selectedFilesLabel = new JLabel("Selected Files");
     JButton selectButton = new JButton("Select Files");
     JButton submitButton = new JButton("Submit");
     JTextArea fileNames = new JTextArea();
//     JComboBox<String> fileNamesList = new JComboBox<>();
     Font fontNormal = new Font("Arial",Font.PLAIN,16);
     selectedFilesLabel.setBounds(150,60,200,30);
     selectButton.setBounds(175,20,150,30);
     submitButton.setBounds(210,300,80,30);
     fileNames.setBounds(75,60,350,230);
//     fileNamesList.setBounds(200,100,200,30);
     selectedFilesLabel.setFont(fontNormal);
     selectedFilesLabel.setHorizontalAlignment(selectedFilesLabel.CENTER);
     fileNames.setEditable(false);
     fileNames.setText(this.Path);
//     add(fileNamesList);
     add(fileNames);
     add(selectedFilesLabel);
     add(selectButton);
     add(submitButton);
     selectFileWindow(selectButton);
     submitFiles(submitButton);
     setLayout(null);
     setVisible(true);
     setTitle("Code Snapper");
     setDefaultCloseOperation(EXIT_ON_CLOSE);
 }
 private void selectFileWindow(JButton select){
//     select.addActionListener(e -> {
//         JFrame f1 = new JFrame();
//         JFileChooser fc = new JFileChooser();
//         fc.setBounds(20, 20, 30, 20); // Adjusted size for the file chooser
//         f1.setSize(400,400);
//         f1.setVisible(true);
//         f1.add(fc);
//         setPath(selectedPath(fc, f1));
//     });
     select.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
         JFrame f1 = new JFrame();
         JFileChooser fc = new JFileChooser();
         fc.setBounds(20, 20, 30, 20); // Adjusted size for the file chooser
         f1.setSize(400,400);
         f1.setVisible(true);
         f1.add(fc);
         selectedPath(fc, f1);
         }
     });
 }

    public String getPath(){
     return this.Path;
    }

    public void submitFiles(JButton submit){
     submit.addActionListener((e) -> {
         System.out.println("clicked");
         System.out.println(this.Path);
     });
 }

 public void selectedPath(JFileChooser fileChooser,JFrame frame){
     int result = fileChooser.showOpenDialog(frame);
     if (result == JFileChooser.APPROVE_OPTION) {
         File selectedFile = fileChooser.getSelectedFile();
         frame.dispose();
         this.Path = selectedFile.getAbsolutePath();
         System.out.println(this.Path);
     }
     frame.dispose();
 }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Ui::new);
    }
}
