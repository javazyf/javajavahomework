
package my.contacteditor;
public class HelpMessage extends javax.swing.JFrame {

   
    public HelpMessage() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        chongzhibangzhu = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("��ֵ����");

        chongzhibangzhu.setColumns(20);
        chongzhibangzhu.setRows(5);
        chongzhibangzhu.setText("1���������ֵ��ҽ����ڲ��׹���Ͳ��״��ͣ�\n 2���˻������˽����Ϣһ��Ҫ���Ʊ��ܲ���͸¶��İ���ˡ�\n 3����ȫ���������Խ������ROOT���ֻ���ˢ��Ҳ�з��գ��������\n 4����ֵ���裺\n��1����½�˻����ڸ�����ҳ����ѡ���ҵĽ�ң�\n��2�������ҳ�ֵ��\n��3�������˶Գ�ֵ�˻�ID�������ֵ��\n��4�����ȷ�ϣ����ֳ�ֵ�ɹ����ڼ���ʾ��ֵ�ɹ���\n 5���й��ڽ�ҳ�ֵ����������������Ա��ѯ���߷�����лл����ʹ�ã�");//��ֵ������Ϣ
        jScrollPane1.setViewportView(chongzhibangzhu);

        jLabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jLabel1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jLabel1)
                .addContainerGap(250, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE,300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );

        pack();
        setResizable(false);
		setLocationRelativeTo(null);
    }

    private void jLabel1AncestorAdded(javax.swing.event.AncestorEvent evt) {
    setDefaultCloseOperation(HelpMessage.DISPOSE_ON_CLOSE);       
    }
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HelpMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HelpMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HelpMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HelpMessage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HelpMessage().setVisible(true);
            }
        });
    }
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea chongzhibangzhu;
}
