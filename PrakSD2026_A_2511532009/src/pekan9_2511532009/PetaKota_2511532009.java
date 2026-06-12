package pekan9_2511532009;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
 
public class PetaKota_2511532009 extends JFrame {
 
   
    private Map<String, java.util.List<String>> adjList_2009;
    private String[]    nodes_2009;
    private Set<String> visited_2009;
    private java.util.List<String> path_2009;
    private java.util.List<String> visitOrder_2009;
    private String      startNode_2009;
    private String      goalNode_2009;
    private String      lastAlgo_2009 = "";
 
    // ===== GUI =====
    private JComboBox<String> cbStart_2009;
    private JComboBox<String> cbGoal_2009;
    private JTextPane         graphPane_2009;   
    private JTextPane         resultPane_2009;  
    private JButton           btnBFS_2009;
    private JButton           btnDFS_2009;
    private JButton           btnReset_2009;
 
    // ===== COLOR PALETTE (light theme) =====
    private static final Color C_BG      = new Color(245, 245, 245);  
    private static final Color C_FG      = new Color(20,  20,  20);   
    private static final Color C_START   = new Color(0,  150,  0);    
    private static final Color C_GOAL    = new Color(200, 30,  30);   
    private static final Color C_PATH    = new Color(180, 120,  0);   
    private static final Color C_VISITED = new Color(30,  80, 180);   
    private static final Color C_EDGE    = new Color(60,  60,  60);  
    private static final Color C_HEADER  = new Color(30,  60, 110);
 
    // ===== CONSTRUCTOR =====
    public PetaKota_2511532009() {
        initGraph_2009();
        initGUI_2009();
    }
 
    
    private void initGraph_2009() {
        nodes_2009 = new String[]{
            "Pantai", "Basko", "UNP", "Lamun Ombak", "Transmart", "UNAND", "PNP"
        };
 
        adjList_2009 = new LinkedHashMap<>();
        for (String n : nodes_2009) adjList_2009.put(n, new ArrayList<>());
 
        addEdge_2009("Pantai",       "Basko");
        addEdge_2009("Pantai",       "UNP");
        addEdge_2009("Pantai",       "Lamun Ombak");
        addEdge_2009("Basko",          "Transmart");
        addEdge_2009("UNP",     "Lamun Ombak");
        addEdge_2009("UNP",     "UNAND");
        addEdge_2009("Lamun Ombak",          "Transmart");
        addEdge_2009("Lamun Ombak",          "UNAND");
        addEdge_2009("Transmart", "PNP");
        addEdge_2009("UNAND",       "PNP");
 
        visited_2009    = new HashSet<>();
        path_2009       = new ArrayList<>();
        visitOrder_2009 = new ArrayList<>();
    }
 
    private void addEdge_2009(String a, String b) {
        adjList_2009.get(a).add(b);
        adjList_2009.get(b).add(a);
    }
 
    //  BFS
  
    public void BFS() {
        visited_2009.clear();
        visitOrder_2009.clear();
        path_2009.clear();
 
        Map<String, String> parent_2009 = new HashMap<>();
        Queue<String> queue_2009 = new LinkedList<>();
        queue_2009.add(startNode_2009);
        visited_2009.add(startNode_2009);
        parent_2009.put(startNode_2009, null);
        boolean found_2009 = false;
 
        while (!queue_2009.isEmpty()) {
            String cur_2009 = queue_2009.poll();
            visitOrder_2009.add(cur_2009);
            if (cur_2009.equals(goalNode_2009)) { found_2009 = true; break; }
            for (String nb_2009 : adjList_2009.get(cur_2009)) {
                if (!visited_2009.contains(nb_2009)) {
                    visited_2009.add(nb_2009);
                    parent_2009.put(nb_2009, cur_2009);
                    queue_2009.add(nb_2009);
                }
            }
        }
        if (found_2009) reconstructPath_2009(parent_2009, goalNode_2009);
        lastAlgo_2009 = "BFS";
        displayGraph();
        displayPath();
    }
 
    //  DFS
  
    public void DFS() {
        visited_2009.clear();
        visitOrder_2009.clear();
        path_2009.clear();
 
        Map<String, String> parent_2009 = new HashMap<>();
        parent_2009.put(startNode_2009, null);
        dfsHelper_2009(startNode_2009, goalNode_2009, parent_2009);
        if (visitOrder_2009.contains(goalNode_2009))
            reconstructPath_2009(parent_2009, goalNode_2009);
        lastAlgo_2009 = "DFS";
        displayGraph();
        displayPath();
    }
 
    private void dfsHelper_2009(String node_2009, String goal_2009,
                                 Map<String, String> parent_2009) {
        visited_2009.add(node_2009);
        visitOrder_2009.add(node_2009);
        if (node_2009.equals(goal_2009)) return;
        for (String nb_2009 : adjList_2009.get(node_2009)) {
            if (!visited_2009.contains(nb_2009)) {
                parent_2009.put(nb_2009, node_2009);
                dfsHelper_2009(nb_2009, goal_2009, parent_2009);
                if (visitOrder_2009.contains(goal_2009)) return;
            }
        }
    }
 
    private void reconstructPath_2009(Map<String, String> parent_2009, String goal_2009) {
        LinkedList<String> tmp_2009 = new LinkedList<>();
        String c_2009 = goal_2009;
        while (c_2009 != null) { tmp_2009.addFirst(c_2009); c_2009 = parent_2009.get(c_2009); }
        path_2009.addAll(tmp_2009);
    }
 
   
    //  RESET GRAPH
    
    public void resetGraph() {
        visited_2009.clear();
        path_2009.clear();
        visitOrder_2009.clear();
        lastAlgo_2009 = "";
        displayGraph();
        clearResult_2009();
    }
 
   
    public void displayGraph() {
       
        StyledDocument doc_2009 = graphPane_2009.getStyledDocument();
        try { doc_2009.remove(0, doc_2009.getLength()); } catch (BadLocationException ignored) {}
 
        appendGraph_2009(doc_2009, "\n");
    
        appendGraph_2009(doc_2009, "   ");
        appendNodeGraph_2009(doc_2009, "Pantai");
        appendGraph_2009(doc_2009, " ------------------- ");
        appendNodeGraph_2009(doc_2009, "Basko");
        appendGraph_2009(doc_2009, "\n");
 
        appendGraph_2009(doc_2009, "      |                            |\n");
 
        appendNodeGraph_2009(doc_2009, "UNP");
        appendGraph_2009(doc_2009, " ------ ");
        appendNodeGraph_2009(doc_2009, "Lamun Ombak");
        appendGraph_2009(doc_2009, " ------ ");
        appendNodeGraph_2009(doc_2009, "Transmart");
        appendGraph_2009(doc_2009, "\n");
 
        appendGraph_2009(doc_2009, "      |              |                    |\n");
 
        appendNodeGraph_2009(doc_2009, "UNAND");
        appendGraph_2009(doc_2009, " --------- + --------- ");
        appendNodeGraph_2009(doc_2009, "PNP");
        appendGraph_2009(doc_2009, "\n");
 
        graphPane_2009.setCaretPosition(0);
    }
 

    private void appendGraph_2009(StyledDocument doc_2009, String text_2009) {
        SimpleAttributeSet attr_2009 = new SimpleAttributeSet();
        StyleConstants.setForeground(attr_2009, C_EDGE);
        StyleConstants.setFontFamily(attr_2009, "Monospaced");
        StyleConstants.setFontSize(attr_2009, 13);
        StyleConstants.setBold(attr_2009, false);
        try { doc_2009.insertString(doc_2009.getLength(), text_2009, attr_2009); }
        catch (BadLocationException ignored) {}
    }
 
    private void appendNodeGraph_2009(StyledDocument doc_2009, String name_2009) {
        SimpleAttributeSet attr_2009 = new SimpleAttributeSet();
        StyleConstants.setFontFamily(attr_2009, "Monospaced");
        StyleConstants.setFontSize(attr_2009, 13);
        StyleConstants.setBold(attr_2009, true);
 
        Color col_2009;
        if (name_2009.equals(startNode_2009) && startNode_2009 != null
                && !visited_2009.isEmpty()) {
            col_2009 = C_START;
        } else if (name_2009.equals(goalNode_2009) && goalNode_2009 != null
                && !visited_2009.isEmpty()) {
            col_2009 = C_GOAL;
        } else if (!path_2009.isEmpty() && path_2009.contains(name_2009)) {
            col_2009 = C_PATH;
        } else if (visited_2009.contains(name_2009)) {
            col_2009 = C_VISITED;
        } else {
            col_2009 = C_FG;
        }
 
        StyleConstants.setForeground(attr_2009, col_2009);
        try { doc_2009.insertString(doc_2009.getLength(), name_2009, attr_2009); }
        catch (BadLocationException ignored) {}
    }
 
    public void displayPath() {
        StyledDocument doc_2009 = resultPane_2009.getStyledDocument();
        try { doc_2009.remove(0, doc_2009.getLength()); } catch (BadLocationException ignored) {}
 
        appendResult_2009(doc_2009, "Hasil Pencarian  : ", C_FG, true);
        appendResult_2009(doc_2009, lastAlgo_2009 + "\n", C_PATH, true);
 
        appendResult_2009(doc_2009, "Jalur            : ", C_FG, true);
        if (path_2009.isEmpty()) {
            appendResult_2009(doc_2009, "Tidak ditemukan\n", C_GOAL, false);
        } else {
            for (int i_2009 = 0; i_2009 < path_2009.size(); i_2009++) {
                String n_2009 = path_2009.get(i_2009);
                Color nc_2009 = n_2009.equals(startNode_2009) ? C_START
                              : n_2009.equals(goalNode_2009)  ? C_GOAL
                              : C_PATH;
                appendResult_2009(doc_2009, n_2009, nc_2009, true);
                if (i_2009 < path_2009.size() - 1)
                    appendResult_2009(doc_2009, " → ", C_EDGE, false);
            }
            appendResult_2009(doc_2009, "\n", C_FG, false);
        }
 
        appendResult_2009(doc_2009, "Node Dikunjungi  : ", C_FG, true);
        for (int i_2009 = 0; i_2009 < visitOrder_2009.size(); i_2009++) {
            String n_2009 = visitOrder_2009.get(i_2009);
            Color nc_2009 = n_2009.equals(startNode_2009) ? C_START
                          : n_2009.equals(goalNode_2009)  ? C_GOAL
                          : C_VISITED;
            appendResult_2009(doc_2009, n_2009, nc_2009, true);
            if (i_2009 < visitOrder_2009.size() - 1)
                appendResult_2009(doc_2009, ", ", C_EDGE, false);
        }
        appendResult_2009(doc_2009, "\n", C_FG, false);
 
        appendResult_2009(doc_2009, "Jumlah Node Dieksplorasi : ", C_FG, true);
        appendResult_2009(doc_2009, String.valueOf(visitOrder_2009.size()), C_PATH, true);
        appendResult_2009(doc_2009, "\n", C_FG, false);
 
        resultPane_2009.setCaretPosition(0);
    }
 
    private void appendResult_2009(StyledDocument doc_2009, String text_2009,
                                    Color color_2009, boolean bold_2009) {
        SimpleAttributeSet a_2009 = new SimpleAttributeSet();
        StyleConstants.setForeground(a_2009, color_2009);
        StyleConstants.setFontFamily(a_2009, "Monospaced");
        StyleConstants.setFontSize(a_2009, 12);
        StyleConstants.setBold(a_2009, bold_2009);
        try { doc_2009.insertString(doc_2009.getLength(), text_2009, a_2009); }
        catch (BadLocationException ignored) {}
    }
 
    private void clearResult_2009() {
        StyledDocument doc_2009 = resultPane_2009.getStyledDocument();
        try { doc_2009.remove(0, doc_2009.getLength()); } catch (BadLocationException ignored) {}
        appendResult_2009(doc_2009, "Hasil Pencarian :\n", C_FG, true);
        appendResult_2009(doc_2009, "Jalur :\n", C_FG, true);
        appendResult_2009(doc_2009, "Node Dikunjungi :\n", C_FG, true);
        appendResult_2009(doc_2009, "Jumlah Node Dieksplorasi : 0", C_FG, true);
    }
 
    // =========================================================
    //  GUI INIT
    // =========================================================
    private void initGUI_2009() {
        setTitle("PENCARIAN JALUR MENGGUNAKAN BFS DAN DFS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(680, 520);
        setLocationRelativeTo(null);
        setResizable(false);
 
        // --- Header ---
        JPanel header_2009 = new JPanel();
        header_2009.setBackground(C_HEADER);
        JLabel title_2009 = new JLabel("PENCARIAN JALUR MENGGUNAKAN BFS DAN DFS");
        title_2009.setForeground(Color.WHITE);
        title_2009.setFont(new Font("Arial", Font.BOLD, 13));
        header_2009.add(title_2009);
 
        // --- Control bar ---
        JPanel ctrl_2009 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 6));
        ctrl_2009.setBackground(new Color(245, 245, 248));
        ctrl_2009.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
 
        cbStart_2009 = new JComboBox<>(nodes_2009);
        cbGoal_2009  = new JComboBox<>(nodes_2009);
        cbGoal_2009.setSelectedItem("Labor AI");
 
        Font comboFont_2009 = new Font("Arial", Font.PLAIN, 12);
        cbStart_2009.setFont(comboFont_2009);
        cbGoal_2009.setFont(comboFont_2009);
 
        JLabel lStart_2009 = new JLabel("Lokasi Awal  : [");
        JLabel lEnd1_2009  = new JLabel("]");
        JLabel lGoal_2009  = new JLabel("  Lokasi Tujuan : [");
        JLabel lEnd2_2009  = new JLabel("]");
 
        for (JLabel l : new JLabel[]{lStart_2009, lEnd1_2009, lGoal_2009, lEnd2_2009}) {
            l.setFont(new Font("Arial", Font.PLAIN, 12));
        }
 
        btnBFS_2009   = makeBtn_2009("[ BFS ]",   new Color(0, 160, 0));
        btnDFS_2009   = makeBtn_2009("[ DFS ]",   new Color(190, 130, 0));
        btnReset_2009 = makeBtn_2009("[ RESET ]", new Color(180, 30, 30));
 
        ctrl_2009.add(lStart_2009);
        ctrl_2009.add(cbStart_2009);
        ctrl_2009.add(lEnd1_2009);
        ctrl_2009.add(lGoal_2009);
        ctrl_2009.add(cbGoal_2009);
        ctrl_2009.add(lEnd2_2009);
        ctrl_2009.add(Box.createHorizontalStrut(10));
        ctrl_2009.add(btnBFS_2009);
        ctrl_2009.add(btnDFS_2009);
        ctrl_2009.add(btnReset_2009);
 
        // --- Graph pane ---
        graphPane_2009 = new JTextPane();
        graphPane_2009.setEditable(false);
        graphPane_2009.setBackground(C_BG);
        graphPane_2009.setForeground(C_FG);
        graphPane_2009.setFont(new Font("Monospaced", Font.PLAIN, 13));
        graphPane_2009.setMargin(new Insets(6, 10, 6, 10));
 
        JScrollPane graphScroll_2009 = new JScrollPane(graphPane_2009);
        graphScroll_2009.setPreferredSize(new Dimension(660, 200));
        graphScroll_2009.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            "VISUALISASI GRAPH",
            TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Monospaced", Font.BOLD, 12), Color.DARK_GRAY));
 
        // --- Result pane ---
        resultPane_2009 = new JTextPane();
        resultPane_2009.setEditable(false);
        resultPane_2009.setBackground(C_BG);
        resultPane_2009.setFont(new Font("Monospaced", Font.BOLD, 12));
        resultPane_2009.setMargin(new Insets(4, 10, 4, 10));
 
        JScrollPane resultScroll_2009 = new JScrollPane(resultPane_2009);
        resultScroll_2009.setPreferredSize(new Dimension(660, 130));
        resultScroll_2009.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY));
 
        // --- Layout ---
        JPanel center_2009 = new JPanel(new BorderLayout(0, 0));
        center_2009.add(ctrl_2009,          BorderLayout.NORTH);
        center_2009.add(graphScroll_2009,   BorderLayout.CENTER);
        center_2009.add(resultScroll_2009,  BorderLayout.SOUTH);
 
        JPanel main_2009 = new JPanel(new BorderLayout());
        main_2009.add(header_2009,  BorderLayout.NORTH);
        main_2009.add(center_2009,  BorderLayout.CENTER);
        setContentPane(main_2009);
 
        // --- Button listeners ---
        btnBFS_2009.addActionListener(e -> {
            startNode_2009 = (String) cbStart_2009.getSelectedItem();
            goalNode_2009  = (String) cbGoal_2009.getSelectedItem();
            if (startNode_2009.equals(goalNode_2009)) {
                JOptionPane.showMessageDialog(this,
                    "Lokasi awal dan tujuan tidak boleh sama!", "Perhatian",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            BFS();
        });
 
        btnDFS_2009.addActionListener(e -> {
            startNode_2009 = (String) cbStart_2009.getSelectedItem();
            goalNode_2009  = (String) cbGoal_2009.getSelectedItem();
            if (startNode_2009.equals(goalNode_2009)) {
                JOptionPane.showMessageDialog(this,
                    "Lokasi awal dan tujuan tidak boleh sama!", "Perhatian",
                    JOptionPane.WARNING_MESSAGE);
                return;
            }
            DFS();
        });
 
        btnReset_2009.addActionListener(e -> resetGraph());
 
        // Initial render
        displayGraph();
        clearResult_2009();
    }
 
    private JButton makeBtn_2009(String label_2009, Color bg_2009) {
        JButton b_2009 = new JButton(label_2009);
        b_2009.setBackground(bg_2009);
        b_2009.setForeground(Color.WHITE);
        b_2009.setFont(new Font("Arial", Font.BOLD, 12));
        b_2009.setFocusPainted(false);
        b_2009.setBorder(BorderFactory.createRaisedBevelBorder());
        return b_2009;
    }
 
  
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PetaKota_2511532009 app_2009 = new PetaKota_2511532009();
            app_2009.setVisible(true);
        });
    }
}