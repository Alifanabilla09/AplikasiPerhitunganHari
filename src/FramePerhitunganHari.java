
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class FramePerhitunganHari extends javax.swing.JFrame {

// Fungsi untuk menyinkronkan JCalendar dengan ComboBox dan Spinner
private void syncCalendarWithComboBoxAndSpinner() {
    int bulan = cbbBulan.getSelectedIndex();  // Indeks bulan (0 = Januari, 1 = Februari, ...)
    int tahun = (Integer) spinnerTahun.getValue();  // Tahun dari JSpinner

    // Set tanggal di JCalendar ke tanggal pertama bulan dan tahun yang dipilih
    LocalDate date = LocalDate.of(tahun, bulan + 1, 1);  // Bulan di LocalDate mulai dari 1 (Januari)
    kalenderPilih.setDate(java.sql.Date.valueOf(date));  // Set tanggal pertama bulan yang dipilih
}

// Fungsi untuk menyinkronkan ComboBox dan Spinner dengan JCalendar
private void syncComboBoxAndSpinnerWithCalendar() {
    // Ambil tanggal yang dipilih dari JCalendar
    LocalDate selectedDate = kalenderPilih.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

    // Set bulan dan tahun di ComboBox dan Spinner berdasarkan tanggal yang dipilih
    cbbBulan.setSelectedIndex(selectedDate.getMonthValue() - 1);  // Bulan di ComboBox (0 = Januari)
    spinnerTahun.setValue(selectedDate.getYear());  // Set tahun di JSpinner
}

// Fungsi untuk menghitung hari pertama, hari terakhir, dan selisih hari dalam bulan yang dipilih
private void hitungHariDanKabisat() {
    // Ambil tanggal yang dipilih dari JCalendar
    LocalDate selectedDate = kalenderPilih.getDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
    
    // Ambil bulan dan tahun
    int bulan = selectedDate.getMonthValue();
    int tahun = selectedDate.getYear();

    // Dapatkan hari pertama bulan tersebut
    LocalDate hariPertama = LocalDate.of(tahun, bulan, 1);
    
    // Dapatkan hari terakhir bulan tersebut
    LocalDate hariTerakhir = hariPertama.withDayOfMonth(hariPertama.lengthOfMonth());
    
    // Hitung selisih hari antara hari pertama dan hari terakhir
    long selisihHari = ChronoUnit.DAYS.between(hariPertama, hariTerakhir);

    // Menampilkan hasil ke JTextArea
    String kabisatStatus = isLeapYear(tahun) ? "Tahun kabisat." : "Bukan tahun kabisat.";
    String hasil = "Hari pertama bulan " + hariPertama.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()) 
                   + " tahun " + tahun + " adalah " + hariPertama.getDayOfWeek() + " " + hariPertama + ".\n"
                   + "Hari terakhir bulan " + hariTerakhir.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()) 
                   + " tahun " + tahun + " adalah " + hariTerakhir.getDayOfWeek() + " " + hariTerakhir + ".\n"
                   + "Selisih hari antara hari pertama dan terakhir adalah " + (selisihHari + 1) + " hari.\n"
                   + kabisatStatus;
    txtArea.setText(hasil);
}

// Fungsi untuk memeriksa apakah tahun kabisat menggunakan LocalDate
private boolean isLeapYear(int year) {
    return LocalDate.of(year, 1, 1).isLeapYear();
}
    /**
     * Creates new form FramePerhitunganHari
     */
    public FramePerhitunganHari() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbbBulan = new javax.swing.JComboBox<>();
        spinnerTahun = new javax.swing.JSpinner();
        kalenderPilih = new com.toedter.calendar.JCalendar();
        btnHitung = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Perhitungan Hari");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Bulan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel1.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Tahun");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel1.add(jLabel3, gridBagConstraints);

        cbbBulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember", " " }));
        cbbBulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbBulanActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel1.add(cbbBulan, gridBagConstraints);

        spinnerTahun.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerTahunStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel1.add(spinnerTahun, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel1.add(kalenderPilih, gridBagConstraints);

        btnHitung.setText("Hitung");
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel1.add(btnHitung, gridBagConstraints);

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 3, 2, 3);
        jPanel1.add(jScrollPane1, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        hitungHariDanKabisat();        // TODO add your handling code here:
    }//GEN-LAST:event_btnHitungActionPerformed

    private void cbbBulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbBulanActionPerformed
        syncCalendarWithComboBoxAndSpinner();  // Sinkronkan kalender dengan bulan dan tahun        // TODO add your handling code here:
    }//GEN-LAST:event_cbbBulanActionPerformed

    private void spinnerTahunStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerTahunStateChanged
        syncCalendarWithComboBoxAndSpinner();  // Sinkronkan kalender dengan bulan dan tahun        // TODO add your handling code here:
    }//GEN-LAST:event_spinnerTahunStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePerhitunganHari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePerhitunganHari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePerhitunganHari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePerhitunganHari.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePerhitunganHari().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHitung;
    private javax.swing.JComboBox<String> cbbBulan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JCalendar kalenderPilih;
    private javax.swing.JSpinner spinnerTahun;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
