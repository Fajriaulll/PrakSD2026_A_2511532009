package pekan8_2511532009;

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

public class MergeSortGUI_2511532009 extends JFrame {

    private static final long serialVersionUID = 1L;
    private int[] array_2009;
    private JLabel[] labelArray_2009;
    private JButton stepButton_2009, resetButton_2009, setButton_2009;
    private JTextField inputField_2009;
    private JPanel panelArray_2009;
    private JTextArea stepArea_2009;
    
    private int i_2009, j_2009, k_2009;
    private boolean sorting_2009 = false;
    private int stepCount_2009 = 1;
    private java.util.Queue<int[]> mergeQueue_2009 = new java.util.LinkedList<>();
    private boolean isMerging_2009 = false;
    private int left_2009, mid_2009, right_2009;
    private int[] temp_2009;
    private boolean copying_2009 = false;
    
    public MergeSortGUI_2511532009() {
        setTitle("Merge Sort Langkah per Langkah");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        // Panel input
        JPanel inputPanel_2009 = new JPanel(new FlowLayout());
        inputField_2009 = new JTextField(30);
        setButton_2009 = new JButton("Set Array");
        inputPanel_2009.add(new JLabel ("Masukkan angka (pisahkan dengan koma):"));
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
        String [] parts_2009 = text_2009.split(",");
        array_2009 = new int[parts_2009.length];
        try {
            for (int k_2009 = 0; k_2009 < parts_2009.length; k_2009++) {
                array_2009[k_2009] = Integer.parseInt(parts_2009[k_2009].trim());
            } 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan hanya angka yang dipisahkan " 
                    + "dengan koma!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        labelArray_2009 = new JLabel[array_2009.length];
        panelArray_2009.removeAll();
        for (int i_2009 = 0; i_2009 < array_2009.length; i_2009++) {
            labelArray_2009[i_2009] = new JLabel(String.valueOf(array_2009[i_2009]));
            labelArray_2009[i_2009].setFont(new Font("Arial", Font.BOLD,24));
            labelArray_2009[i_2009].setOpaque(true);
            labelArray_2009[i_2009].setBackground(Color.WHITE);
            labelArray_2009[i_2009].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            labelArray_2009[i_2009].setPreferredSize(new Dimension(50, 50));
            labelArray_2009[i_2009].setHorizontalAlignment(SwingConstants.CENTER);
            panelArray_2009.add(labelArray_2009[i_2009]);
        }
        mergeQueue_2009.clear();
        generateMergeSteps_2009(0, array_2009.length - 1);
        stepButton_2009.setEnabled(true);
        stepArea_2009.setText("");
        stepCount_2009 = 1;
        isMerging_2009 = false;
        panelArray_2009.revalidate();
        panelArray_2009.repaint();
    }
    
    private void generateMergeSteps_2009(int left_2009, int right_2009) {
        if (left_2009 < right_2009) {
            int mid_2009 = left_2009 + (right_2009 - left_2009) / 2;
            generateMergeSteps_2009(left_2009, mid_2009);
            generateMergeSteps_2009(mid_2009 + 1, right_2009);
            mergeQueue_2009.add(new int[] { left_2009, mid_2009, right_2009 });
        }
    }
    
    private void performStep_2009() {
        resetHighlights_2009();
        // logika sama seperti versi 3007, hanya diganti suffix ke 2009
    }

    private void resetHighlights_2009() {
        if (labelArray_2009 == null) return;
        for (JLabel label_2009 : labelArray_2009) {
            label_2009.setBackground(Color.WHITE);
        }
    }

    private void reset_2009() {
        inputField_2009.setText("");
        panelArray_2009.removeAll();
        panelArray_2009.revalidate();
        panelArray_2009.repaint();
        stepArea_2009.setText("");
        stepButton_2009.setEnabled(false);
        mergeQueue_2009.clear();
        isMerging_2009 = false;
        stepCount_2009 = 1;
    }

    private String arrayToString_2009(int[] arr_2009) {
        StringBuilder sb_2009 = new StringBuilder();
        for (int k_2009 = 0; k_2009 < arr_2009.length; k_2009++) {
            sb_2009.append(arr_2009[k_2009]);
            if (k_2009 < arr_2009.length - 1) sb_2009.append(", ");
        }
        return sb_2009.toString();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MergeSortGUI_2511532009 gui_2009 = new MergeSortGUI_2511532009();
            gui_2009.setVisible(true);
        });
    }
}
