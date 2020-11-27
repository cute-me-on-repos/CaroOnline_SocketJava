/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view.scene;

import client.RunClient;
import client.model.ProfileData;
import java.util.HashMap;
import javax.swing.ImageIcon;
import shared.constant.Avatar;

/**
 *
 * @author Hoang Tran < hoang at 99.hoangtran@gmail.com >
 */
public class Profile extends javax.swing.JFrame {

    HashMap<String, ImageIcon> hAvatar = new HashMap<>();
    ProfileData currentProfile = new ProfileData();

    /**
     * Creates new form ProfileData
     */
    public Profile() {
        initComponents();
        this.setLocationRelativeTo(null);

        // hide cancel/save button in profile
        plProfileBtn.setVisible(false);

        // avatar combobox
        cbAvatar.setMaximumRowCount(5);
        setAvatar(Avatar.LIST);
    }

    private void setAvatar(String[] avas) {
        cbAvatar.removeAllItems();
        hAvatar.clear();

        for (String s : avas) {
            ImageIcon i = new ImageIcon(Avatar.PATH + s);
            hAvatar.put(s, i);
            cbAvatar.addItem(i);
        }
    }

    private String getCurrentStreakStr(int currentStreak) {
        if (currentStreak > 0) {
            return "thắng " + currentStreak;
        }

        if (currentStreak < 0) {
            return "thua " + currentStreak;
        }

        return "" + currentStreak;
    }

    public void loadProfileData(String email) {
        setLoading(true);
        RunClient.socketHandler.getProfile(email);
    }

    public void setProfileData(ProfileData p) {

        // save current profile
        currentProfile = p;
        boolean isMe = p.getEmail().equals(RunClient.socketHandler.getEmail());

        // put data to form
        plContainer.setBorder(javax.swing.BorderFactory.createTitledBorder("Người chơi #" + p.getId()));
        txEmail.setText(p.getEmail());
        txName.setText(p.getName());
        txYearOfBirth.setText("" + p.getYearOfBirth());
        cbGender.setSelectedItem(p.getGender());
        cbAvatar.setSelectedItem(hAvatar.get(p.getAvatar()));

        lbScore.setText(String.valueOf(p.getScore()));
        lbMatchCount.setText("" + p.getMatchCount());
        lbCurrentStreak.setText(getCurrentStreakStr(p.getCurrentStreak()));
        lbWinRate.setText(p.getWinRate() + "%");

        // editable chỉ khi là tài khoản của mình
        txEmail.setEditable(isMe);
        txName.setEditable(isMe);
        txYearOfBirth.setEditable(isMe);
        cbGender.setEnabled(isMe);
        plProfileBtn.setVisible(isMe);
    }

    public void setProfileSaveLoading(boolean status) {
        btnProfileSave.setText(status ? "Đang xử lý" : "Lưu");
        btnProfileSave.setEnabled(!status);
        btnProfileCancel.setEnabled(!status);

        pgbProfileLoading.setVisible(status);
    }

    public void setLoading(boolean status) {
        pgbProfileLoading.setVisible(status);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plContainer = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbEmail = new javax.swing.JLabel();
        txEmail = new javax.swing.JTextField();
        lbUserName = new javax.swing.JLabel();
        txName = new javax.swing.JTextField();
        lbGender = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        lbBirthday = new javax.swing.JLabel();
        txYearOfBirth = new javax.swing.JTextField();
        plProfileBtn = new javax.swing.JPanel();
        btnProfileSave = new javax.swing.JButton();
        btnProfileCancel = new javax.swing.JButton();
        btnProfileChangePass = new javax.swing.JButton();
        lbPassword = new javax.swing.JLabel();
        pgbProfileLoading = new javax.swing.JProgressBar();
        jPanel6 = new javax.swing.JPanel();
        cbAvatar = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbScore = new javax.swing.JLabel();
        lbMatchCount = new javax.swing.JLabel();
        lbCurrentStreak = new javax.swing.JLabel();
        lbWinRate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hồ sơ");

        plContainer.setBorder(javax.swing.BorderFactory.createTitledBorder("Người chơi"));

        lbEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/view/asset/icons8_email_48px.png"))); // NOI18N

        txEmail.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txEmail.setToolTipText("Email");

        lbUserName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/view/asset/icons8_name_48px_1.png"))); // NOI18N

        txName.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txName.setToolTipText("Họ tên");

        lbGender.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lbGender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/view/asset/icons8_gender_48px.png"))); // NOI18N

        cbGender.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Ẩn" }));
        cbGender.setToolTipText("Giới tính");
        cbGender.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lbBirthday.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lbBirthday.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/view/asset/icons8_birthday_cake_48px_2.png"))); // NOI18N

        txYearOfBirth.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txYearOfBirth.setToolTipText("Năm sinh");

        btnProfileSave.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnProfileSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/view/asset/icons8_ok_24px.png"))); // NOI18N
        btnProfileSave.setText("Lưu");
        btnProfileSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileSaveActionPerformed(evt);
            }
        });

        btnProfileCancel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnProfileCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/view/asset/icons8_cancel_24px.png"))); // NOI18N
        btnProfileCancel.setText("Hủy");
        btnProfileCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileCancelActionPerformed(evt);
            }
        });

        btnProfileChangePass.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnProfileChangePass.setText("Đổi mật khẩu");
        btnProfileChangePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileChangePassActionPerformed(evt);
            }
        });

        lbPassword.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lbPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/view/asset/icons8_password_48px.png"))); // NOI18N

        javax.swing.GroupLayout plProfileBtnLayout = new javax.swing.GroupLayout(plProfileBtn);
        plProfileBtn.setLayout(plProfileBtnLayout);
        plProfileBtnLayout.setHorizontalGroup(
            plProfileBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plProfileBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProfileChangePass)
                .addContainerGap(108, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plProfileBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnProfileCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProfileSave)
                .addContainerGap())
        );
        plProfileBtnLayout.setVerticalGroup(
            plProfileBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plProfileBtnLayout.createSequentialGroup()
                .addGroup(plProfileBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbPassword)
                    .addComponent(btnProfileChangePass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plProfileBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProfileSave)
                    .addComponent(btnProfileCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pgbProfileLoading.setIndeterminate(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pgbProfileLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(lbEmail)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txEmail))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(lbUserName)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txName))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(lbGender)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbGender, 0, 228, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbBirthday)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txYearOfBirth))))
                    .addComponent(plProfileBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txYearOfBirth)
                    .addComponent(lbBirthday))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGender)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plProfileBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pgbProfileLoading, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        cbAvatar.setToolTipText("Ảnh đại diện");
        cbAvatar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Điểm");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Số trận");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Chuỗi");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Tỉ lệ thắng");

        lbScore.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lbScore.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbScore.setText("_");
        lbScore.setToolTipText("");

        lbMatchCount.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lbMatchCount.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbMatchCount.setText("_");

        lbCurrentStreak.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lbCurrentStreak.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbCurrentStreak.setText("_");

        lbWinRate.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        lbWinRate.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbWinRate.setText("_%");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbScore, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addComponent(lbMatchCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbWinRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbCurrentStreak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbScore))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbMatchCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbCurrentStreak))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lbWinRate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout plContainerLayout = new javax.swing.GroupLayout(plContainer);
        plContainer.setLayout(plContainerLayout);
        plContainerLayout.setHorizontalGroup(
            plContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plContainerLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(plContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        plContainerLayout.setVerticalGroup(
            plContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(plContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfileChangePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileChangePassActionPerformed
        RunClient.openScene(RunClient.SceneName.CHANGEPASSWORD);
    }//GEN-LAST:event_btnProfileChangePassActionPerformed

    private void btnProfileSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileSaveActionPerformed
        // loading
        setProfileSaveLoading(true);

        // get data from form
        String email = txEmail.getText();
        String name = txName.getText();
        String avatar = Avatar.getAvatarFilNameFromPath(cbAvatar.getSelectedItem().toString());
        String yearOfBirth = txYearOfBirth.getText();
        String gender = cbGender.getSelectedItem().toString();

        // TODO validate data
        // call sockethandler function
        RunClient.socketHandler.editProfile(email, name, avatar, yearOfBirth, gender);
    }//GEN-LAST:event_btnProfileSaveActionPerformed

    private void btnProfileCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileCancelActionPerformed
        setProfileData(currentProfile);
    }//GEN-LAST:event_btnProfileCancelActionPerformed

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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProfileCancel;
    private javax.swing.JButton btnProfileChangePass;
    private javax.swing.JButton btnProfileSave;
    private javax.swing.JComboBox<ImageIcon> cbAvatar;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbBirthday;
    private javax.swing.JLabel lbCurrentStreak;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbMatchCount;
    private javax.swing.JLabel lbPassword;
    private javax.swing.JLabel lbScore;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JLabel lbWinRate;
    private javax.swing.JProgressBar pgbProfileLoading;
    private javax.swing.JPanel plContainer;
    private javax.swing.JPanel plProfileBtn;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txName;
    private javax.swing.JTextField txYearOfBirth;
    // End of variables declaration//GEN-END:variables
}
