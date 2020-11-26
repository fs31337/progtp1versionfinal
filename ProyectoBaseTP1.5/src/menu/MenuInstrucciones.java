package menu;


public class MenuInstrucciones extends javax.swing.JDialog {
	
	private javax.swing.JButton botonEntendido;
    private javax.swing.JLabel etiquetaInstrucciones;
    private javax.swing.JPanel panel;
   
    public MenuInstrucciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        iniciarComponentes();
        this.setLocationRelativeTo(null);
    }
          
    private void iniciarComponentes() {

        panel = new javax.swing.JPanel();
        panel.setBackground(java.awt.Color.BLACK );
        etiquetaInstrucciones = new javax.swing.JLabel();
        botonEntendido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etiquetaInstrucciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        etiquetaInstrucciones.setText("-Instruccioes a desarrollar:");
        etiquetaInstrucciones.setForeground(java.awt.Color.WHITE);
        
        botonEntendido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonEntendido.setText("Entendido!");
        botonEntendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEntendidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(etiquetaInstrucciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(574, Short.MAX_VALUE)
                .addComponent(botonEntendido)
                .addGap(43, 43, 43))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(etiquetaInstrucciones, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(botonEntendido)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                       

    private void botonEntendidoActionPerformed(java.awt.event.ActionEvent evt) {                                               
        this.dispose();
    }                                              
               
}

