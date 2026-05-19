package pekan7_2511532009;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class InsertionSortGUI_2511532009 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane_2009;
    private int[] array_2009;
    private JLabel[] labelArray_2009;
    private JButton stepButton_2009, resetButton_2009, setButton_2009;
    private JTextField inputField_2009;
    private JPanel panelArray_2009;
    private JTextArea stepArea_2009;
    
    private int i_2009 = 1, j_2009;
    private boolean sorting_2009 = false;
    private int stepCount_2009 = 1;
    
    public InsertionSortGUI_2511532009() {
        setTitle("Insertion Sort Langkah per Langkah");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        // Panel input
        JPanel inputPanel_2009 = new JPanel(new FlowLayout());
        inputField_2009 = new JTextField(30);
        setButton_2009 = new JButton("Set Array");
        inputPanel_2009.add(new JLabel("Masukkan angka (pisahkan dengan koma):"));
        inputPanel_2009.add(inputField_2009);
        inputPanel_2009.add(setButton_2009);
        
        // Panel array visual
        panelArray_2009 = new JPanel();
        panelArray_2009.setLayout(new FlowLayout());
        
        // Panel kontrol
        JPanel controlPanel_2009 = new JPanel();
        stepButton_2009 = new JButton("Langkah Selanjutnya");
        resetButton_2009 = new JButton("Reset");
        stepButton_2009.setEnabled(false);
        controlPanel_2009.add(stepButton_2009);
        controlPanel_2009.add(resetButton_2009);
        
        // Area teks untuk log langkah-langkah
        stepArea_2009 = new JTextArea(8, 60);
        stepArea_2009.setEditable(false);
        stepArea_2009.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane_2009 = new JScrollPane(stepArea_2009);
        
        // Tambahkan panel ke frame
        add(inputPanel_2009, BorderLayout.NORTH);
        add(panelArray_2009, BorderLayout.CENTER);
        add(controlPanel_2009, BorderLayout.SOUTH);
        add(scrollPane_2009, BorderLayout.EAST);
        
        // Event Set Array
        setButton_2009.addActionListener(e -> setArrayFromInput());
        
        // Event Langkah Selanjutnya
        stepButton_2009.addActionListener(e -> performStep_2009());
        
        // Event Reset
        resetButton_2009.addActionListener(e -> reset_2009());
    }
    
    private void setArrayFromInput() {
        String text_2009 = inputField_2009.getText().trim();
        if (text_2009.isEmpty()) return;
        String[] parts = text_2009.split(",");
        array_2009 = new int[parts.length];
        try {
            for (int k_2009 = 0; k_2009 < parts.length; k_2009++) {
                array_2009[k_2009] = Integer.parseInt(parts[k_2009].trim());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan hanya angka yang dipisahkan " 
                    + "dengan koma!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        i_2009 = 1;
        stepCount_2009 = 1;
        sorting_2009 = true;
        stepButton_2009.setEnabled(true);
        stepArea_2009.setText("");
        panelArray_2009.removeAll();
        labelArray_2009 = new JLabel[array_2009.length];
        for (int k_2009 = 0; k_2009 < array_2009.length; k_2009++) {
            labelArray_2009[k_2009] = new JLabel(String.valueOf(array_2009[k_2009]));
            labelArray_2009[k_2009].setFont(new Font("Arial", Font.BOLD, 24));
            labelArray_2009[k_2009].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_2009[k_2009].setPreferredSize(new Dimension(50, 50));
            labelArray_2009[k_2009].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_2009.add(labelArray_2009[k_2009]);
        }
        panelArray_2009.revalidate();
        panelArray_2009.repaint();
    }
    
    private void performStep_2009() {
        if (i_2009 < array_2009.length && sorting_2009) {
            int key_2009 = array_2009[i_2009];
            j_2009 = i_2009 - 1;
            
            StringBuilder stepLog_2009 = new StringBuilder();
            stepLog_2009.append("Langkah ").append(stepCount_2009).
            append(": Memasukkan ").append(key_2009).append("\n");
            
            while (j_2009 >= 0 && array_2009[j_2009] > key_2009) {
                array_2009[j_2009 + 1] = array_2009[j_2009];
                j_2009--;
            }
            array_2009[j_2009 + 1] = key_2009;
            
            updateLabels_2009();
            stepLog_2009.append("Hasil: ").append(arrayToString_2009(array_2009)).append("\n\n");
            stepArea_2009.append(stepLog_2009.toString());
            
            i_2009++;
            stepCount_2009++;
            
            if (i_2009 == array_2009.length) {
                sorting_2009 = false;
                stepButton_2009.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Sorting selesai!");
            }
        }
    }
    
    private void updateLabels_2009() {
        for (int k_2009 = 0; k_2009 < array_2009.length; k_2009++) {
            labelArray_2009[k_2009].setText(String.valueOf(array_2009[k_2009]));
        }
    }
    
    private void reset_2009() {
        inputField_2009.setText("");
        panelArray_2009.removeAll();
        panelArray_2009.revalidate();
        panelArray_2009.repaint();
        stepArea_2009.setText("");
        stepButton_2009.setEnabled(false);
        sorting_2009 = false;
        i_2009 = 1;
        stepCount_2009 = 1;
    }
    
    private String arrayToString_2009(int[] arr) {
        StringBuilder sb_2009 = new StringBuilder();
        for (int k_2009 = 0; k_2009 < arr.length; k_2009++) {
            sb_2009.append(arr[k_2009]);
            if (k_2009 < arr.length - 1) sb_2009.append(", ");
        }
        return sb_2009.toString();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InsertionSortGUI_2511532009 gui_2009 = new InsertionSortGUI_2511532009();
            gui_2009.setVisible(true);
        });
    }
}
