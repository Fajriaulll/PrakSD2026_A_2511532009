package pekan7_2511532009;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class SortingMahasiswaGUI_2511532009 extends JFrame {

    private static final long serialVersionUID = 1L;

    // Data mahasiswa
    private ArrayList<Mahasiswa_2511532009> listMahasiswa_2009 = new ArrayList<>();

    // Komponen input
    private JTextField fieldNama_2009, fieldNim_2009, fieldProdi_2009;
    private JButton btnTambah_2009, btnHapus_2009, btnMulaiSorting_2009, btnReset_2009;
    private JComboBox<String> comboAlgoritma_2009;

    // Tabel data
    private JTable tableMahasiswa_2009;
    private DefaultTableModel tableModel_2009;

    // Area visualisasi sorting
    private JTextArea areaVisualisasi_2009;

    public SortingMahasiswaGUI_2511532009() {
        setTitle("Sorting Nama Mahasiswa - Pekan 7");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ===================== PANEL INPUT (NORTH) =====================
        JPanel panelInput_2009 = new JPanel(new GridLayout(4, 2, 5, 5));
        panelInput_2009.setBorder(BorderFactory.createTitledBorder("Input Data Mahasiswa"));

        fieldNama_2009 = new JTextField();
        fieldNim_2009 = new JTextField();
        fieldProdi_2009 = new JTextField();

        panelInput_2009.add(new JLabel("  Nama Mahasiswa :"));
        panelInput_2009.add(fieldNama_2009);
        panelInput_2009.add(new JLabel("  NIM :"));
        panelInput_2009.add(fieldNim_2009);
        panelInput_2009.add(new JLabel("  Program Studi :"));
        panelInput_2009.add(fieldProdi_2009);

        // Tombol tambah dan hapus
        JPanel panelTombolInput_2009 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnTambah_2009 = new JButton("Tambah Data");
        btnHapus_2009 = new JButton("Hapus Data");
        btnTambah_2009.setBackground(new Color(70, 130, 180));
        btnTambah_2009.setForeground(Color.WHITE);
        btnHapus_2009.setBackground(new Color(220, 80, 80));
        btnHapus_2009.setForeground(Color.WHITE);
        panelTombolInput_2009.add(btnTambah_2009);
        panelTombolInput_2009.add(btnHapus_2009);
        panelInput_2009.add(new JLabel(""));
        panelInput_2009.add(panelTombolInput_2009);

        // ===================== PANEL TABEL (CENTER-LEFT) =====================
        String[] kolomHeader_2009 = {"Nama Mahasiswa", "NIM", "Program Studi"};
        tableModel_2009 = new DefaultTableModel(kolomHeader_2009, 0);
        tableMahasiswa_2009 = new JTable(tableModel_2009);
        tableMahasiswa_2009.setFont(new Font("Arial", Font.PLAIN, 13));
        tableMahasiswa_2009.setRowHeight(25);
        tableMahasiswa_2009.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        JScrollPane scrollTabel_2009 = new JScrollPane(tableMahasiswa_2009);
        scrollTabel_2009.setBorder(BorderFactory.createTitledBorder("Daftar Mahasiswa"));
        scrollTabel_2009.setPreferredSize(new Dimension(420, 250));

        // ===================== PANEL SORTING (CENTER-RIGHT) =====================
        JPanel panelSorting_2009 = new JPanel(new BorderLayout(5, 5));
        panelSorting_2009.setBorder(BorderFactory.createTitledBorder("Pilih Algoritma Sorting"));

        String[] algoritmaList_2009 = {"Insertion Sort", "Selection Sort", "Bubble Sort"};
        comboAlgoritma_2009 = new JComboBox<>(algoritmaList_2009);
        comboAlgoritma_2009.setFont(new Font("Arial", Font.PLAIN, 13));

        JPanel panelKombo_2009 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelKombo_2009.add(new JLabel("Algoritma :"));
        panelKombo_2009.add(comboAlgoritma_2009);

        btnMulaiSorting_2009 = new JButton("Mulai Sorting");
        btnReset_2009 = new JButton("Reset Visualisasi");
        btnMulaiSorting_2009.setBackground(new Color(60, 170, 90));
        btnMulaiSorting_2009.setForeground(Color.WHITE);
        btnReset_2009.setBackground(new Color(150, 150, 150));
        btnReset_2009.setForeground(Color.WHITE);
        btnMulaiSorting_2009.setFont(new Font("Arial", Font.BOLD, 13));

        JPanel panelTombolSort_2009 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTombolSort_2009.add(btnMulaiSorting_2009);
        panelTombolSort_2009.add(btnReset_2009);

        panelSorting_2009.add(panelKombo_2009, BorderLayout.NORTH);
        panelSorting_2009.add(panelTombolSort_2009, BorderLayout.SOUTH);

        // ===================== PANEL TENGAH =====================
        JPanel panelTengah_2009 = new JPanel(new BorderLayout(10, 0));
        panelTengah_2009.add(scrollTabel_2009, BorderLayout.CENTER);
        panelTengah_2009.add(panelSorting_2009, BorderLayout.EAST);

        // ===================== PANEL VISUALISASI (SOUTH) =====================
        areaVisualisasi_2009 = new JTextArea(12, 70);
        areaVisualisasi_2009.setEditable(false);
        areaVisualisasi_2009.setFont(new Font("Monospaced", Font.PLAIN, 13));
        areaVisualisasi_2009.setBackground(new Color(245, 245, 245));
        JScrollPane scrollVisualisasi_2009 = new JScrollPane(areaVisualisasi_2009);
        scrollVisualisasi_2009.setBorder(BorderFactory.createTitledBorder("Visualisasi Proses Sorting"));

        // ===================== TAMBAHKAN KE FRAME =====================
        add(panelInput_2009, BorderLayout.NORTH);
        add(panelTengah_2009, BorderLayout.CENTER);
        add(scrollVisualisasi_2009, BorderLayout.SOUTH);

        // ===================== EVENT LISTENER =====================
        btnTambah_2009.addActionListener(e -> tambahData_2009());
        btnHapus_2009.addActionListener(e -> hapusData_2009());
        btnMulaiSorting_2009.addActionListener(e -> mulaiSorting_2009());
        btnReset_2009.addActionListener(e -> resetVisualisasi_2009());
    }

    // Tambah data mahasiswa ke tabel dan list
    private void tambahData_2009() {
        String nama_2009 = fieldNama_2009.getText().trim();
        String nim_2009 = fieldNim_2009.getText().trim();
        String prodi_2009 = fieldProdi_2009.getText().trim();

        if (nama_2009.isEmpty() || nim_2009.isEmpty() || prodi_2009.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Peringatan",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Mahasiswa_2511532009 mhs_2009 = new Mahasiswa_2511532009(nama_2009, nim_2009, prodi_2009);
        listMahasiswa_2009.add(mhs_2009);
        tableModel_2009.addRow(new Object[]{nama_2009, nim_2009, prodi_2009});

        // Bersihkan field setelah tambah
        fieldNama_2009.setText("");
        fieldNim_2009.setText("");
        fieldProdi_2009.setText("");
        fieldNama_2009.requestFocus();
    }

    // Hapus data mahasiswa yang dipilih dari tabel
    private void hapusData_2009() {
        int baris_2009 = tableMahasiswa_2009.getSelectedRow();
        if (baris_2009 == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Peringatan",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        listMahasiswa_2009.remove(baris_2009);
        tableModel_2009.removeRow(baris_2009);
    }

    // Reset area visualisasi
    private void resetVisualisasi_2009() {
        areaVisualisasi_2009.setText("");
    }

    // Mulai sorting sesuai algoritma yang dipilih
    private void mulaiSorting_2009() {
        if (listMahasiswa_2009.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Belum ada data mahasiswa!", "Peringatan",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Salin data awal (identik untuk ketiga algoritma)
        ArrayList<Mahasiswa_2511532009> dataSorting_2009 = salinData_2009(listMahasiswa_2009);
        String pilihan_2009 = (String) comboAlgoritma_2009.getSelectedItem();

        areaVisualisasi_2009.setText("");

        // Jalankan algoritma sesuai pilihan
        if ("Insertion Sort".equals(pilihan_2009)) {
            insertionSort_2009(dataSorting_2009);
        } else if ("Selection Sort".equals(pilihan_2009)) {
            selectionSort_2009(dataSorting_2009);
        } else if ("Bubble Sort".equals(pilihan_2009)) {
            bubbleSort_2009(dataSorting_2009);
        }
    }

    // Salin ArrayList agar data awal tidak berubah
    private ArrayList<Mahasiswa_2511532009> salinData_2009(ArrayList<Mahasiswa_2511532009> sumber_2009) {
        ArrayList<Mahasiswa_2511532009> salinan_2009 = new ArrayList<>();
        for (Mahasiswa_2511532009 mhs_2009 : sumber_2009) {
            salinan_2009.add(new Mahasiswa_2511532009(
                    mhs_2009.getNama_2009(),
                    mhs_2009.getNim_2009(),
                    mhs_2009.getProdi_2009()
            ));
        }
        return salinan_2009;
    }

    // Konversi list ke string nama untuk ditampilkan
    private String listKeString_2009(ArrayList<Mahasiswa_2511532009> list_2009) {
        StringBuilder sb_2009 = new StringBuilder("[");
        for (int k_2009 = 0; k_2009 < list_2009.size(); k_2009++) {
            sb_2009.append(list_2009.get(k_2009).getNama_2009());
            if (k_2009 < list_2009.size() - 1) sb_2009.append(", ");
        }
        sb_2009.append("]");
        return sb_2009.toString();
    }

    // ===================== INSERTION SORT =====================
    private void insertionSort_2009(ArrayList<Mahasiswa_2511532009> arr_2009) {
        int n_2009 = arr_2009.size();
        StringBuilder log_2009 = new StringBuilder();
        log_2009.append("=== INSERTION SORT ===\n");
        log_2009.append("Data awal : ").append(listKeString_2009(arr_2009)).append("\n\n");

        // Proses sorting insertion sort
        for (int i_2009 = 1; i_2009 < n_2009; i_2009++) {
            Mahasiswa_2511532009 key_2009 = arr_2009.get(i_2009);
            int j_2009 = i_2009 - 1;

            // Geser elemen yang lebih besar dari key ke kanan
            while (j_2009 >= 0 && arr_2009.get(j_2009).getNama_2009()
                    .compareToIgnoreCase(key_2009.getNama_2009()) > 0) {
                arr_2009.set(j_2009 + 1, arr_2009.get(j_2009));
                j_2009--;
            }
            arr_2009.set(j_2009 + 1, key_2009);

            // Tampilkan hasil tiap langkah
            log_2009.append("Langkah ").append(i_2009)
                    .append(" : ").append(listKeString_2009(arr_2009)).append("\n");
        }

        log_2009.append("\nHasil Akhir : ").append(listKeString_2009(arr_2009)).append("\n");
        areaVisualisasi_2009.setText(log_2009.toString());
    }

    // ===================== SELECTION SORT =====================
    private void selectionSort_2009(ArrayList<Mahasiswa_2511532009> arr_2009) {
        int n_2009 = arr_2009.size();
        StringBuilder log_2009 = new StringBuilder();
        log_2009.append("=== SELECTION SORT ===\n");
        log_2009.append("Data awal : ").append(listKeString_2009(arr_2009)).append("\n\n");

        // Proses sorting selection sort
        for (int i_2009 = 0; i_2009 < n_2009 - 1; i_2009++) {
            int minIndex_2009 = i_2009;

            // Cari index minimum dari sisa elemen
            for (int j_2009 = i_2009 + 1; j_2009 < n_2009; j_2009++) {
                if (arr_2009.get(j_2009).getNama_2009()
                        .compareToIgnoreCase(arr_2009.get(minIndex_2009).getNama_2009()) < 0) {
                    minIndex_2009 = j_2009;
                }
            }

            // Tukar elemen minimum dengan posisi i
            Mahasiswa_2511532009 temp_2009 = arr_2009.get(i_2009);
            arr_2009.set(i_2009, arr_2009.get(minIndex_2009));
            arr_2009.set(minIndex_2009, temp_2009);

            // Tampilkan hasil tiap pass
            log_2009.append("Pass ").append(i_2009 + 1)
                    .append(" : ").append(listKeString_2009(arr_2009)).append("\n");
        }

        log_2009.append("\nHasil Akhir : ").append(listKeString_2009(arr_2009)).append("\n");
        areaVisualisasi_2009.setText(log_2009.toString());
    }

    // ===================== BUBBLE SORT =====================
    private void bubbleSort_2009(ArrayList<Mahasiswa_2511532009> arr_2009) {
        int n_2009 = arr_2009.size();
        StringBuilder log_2009 = new StringBuilder();
        log_2009.append("=== BUBBLE SORT ===\n");
        log_2009.append("Data awal : ").append(listKeString_2009(arr_2009)).append("\n\n");

        // Proses sorting bubble sort
        for (int i_2009 = 0; i_2009 < n_2009 - 1; i_2009++) {
            boolean adaSwap_2009 = false;

            // Bandingkan dan tukar elemen yang berdekatan
            for (int j_2009 = 0; j_2009 < n_2009 - i_2009 - 1; j_2009++) {
                if (arr_2009.get(j_2009).getNama_2009()
                        .compareToIgnoreCase(arr_2009.get(j_2009 + 1).getNama_2009()) > 0) {
                    Mahasiswa_2511532009 temp_2009 = arr_2009.get(j_2009);
                    arr_2009.set(j_2009, arr_2009.get(j_2009 + 1));
                    arr_2009.set(j_2009 + 1, temp_2009);
                    adaSwap_2009 = true;
                }
            }

            // Tampilkan hasil tiap pass
            log_2009.append("Pass ").append(i_2009 + 1)
                    .append(" : ").append(listKeString_2009(arr_2009)).append("\n");

            // Jika tidak ada swap, array sudah terurut
            if (!adaSwap_2009) break;
        }

        log_2009.append("\nHasil Akhir : ").append(listKeString_2009(arr_2009)).append("\n");
        areaVisualisasi_2009.setText(log_2009.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SortingMahasiswaGUI_2511532009 gui_2009 = new SortingMahasiswaGUI_2511532009();
            gui_2009.setVisible(true);
        });
    }
}