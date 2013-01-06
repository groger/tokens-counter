

package compteurjetons2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.SwingWorker;

/**
 *
 * @author gwendo
 */
public class Main extends javax.swing.JFrame {

     /*File choisit pour la fonction de compter*/
    File FichierSelectionner;

    /*Nom de fichier choisi*/
    private String FileName;

    /*Variable qui cree une task*/
    private Task task;

    private PropertyChangeListener change;

    /*counter objet de CompteurJetons notre modele*/
    CompteurJetons counter = new CompteurJetons();

    /*FileChooser  variable de type Jfilechooser*/
    JFileChooser FileChooser = new JFileChooser();
    
    public Main() {
        initComponents();
        NombreJetons.setEditable(false);//permet de ne pas entrer de variables dans nbjetons
        Annuler.setEnabled(false); //desactive le bouton annuler
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fichier = new javax.swing.JButton();
        Compteur = new javax.swing.JButton();
        Annuler = new javax.swing.JButton();
        BarreProgres = new javax.swing.JProgressBar();
        Progres = new java.awt.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        NombreJetons = new javax.swing.JTextPane();
        NbrJetons = new java.awt.Label();
        CheminFichier = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Fichier.setText("Fichier");
        Fichier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FichierActionPerformed(evt);
            }
        });

        Compteur.setText("Compter");
        Compteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompteurActionPerformed(evt);
            }
        });

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });

        Progres.setText("Progres");

        jScrollPane1.setViewportView(NombreJetons);

        NbrJetons.setText("Nombre de jetons : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NbrJetons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Progres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BarreProgres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CheminFichier, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Fichier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Compteur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Annuler, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CheminFichier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Fichier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Compteur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NbrJetons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Annuler)
                    .addComponent(BarreProgres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Progres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

       class Task extends SwingWorker<Integer, Integer> {
        /*Fonction à effectuer sur le fil worker, en arriere*/
        public Integer doInBackground() {
            try {
                counter.Compte(FichierSelectionner, change);//action de compter le nombre de jetons
            } catch (java.io.FileNotFoundException e){
                System.out.println("Fichier "+FichierSelectionner+" non trouvé");
            }
            return null;
        }

        /*Method executée quand le nombre de jetons total compté est terminé*/
        @Override
        public void done() {
            Annuler.setEnabled(false);//desactive le bouton annuler
            NombreJetons.setText("" + counter.nJetons);//on affiche le nombre de jetons total
            BarreProgres.setValue(counter.getProgres());//on met à jour la barre de progress
            Compteur.setEnabled(true);//active le bouton Compteur
            counter = new CompteurJetons();
        }
    }
       
    private void CompteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompteurActionPerformed
        // TODO add your handling code here:
           /*Bouton Compteur pour commencer le compte des jetons*/
        Annuler.setEnabled(true);//active le bouton Annuler
        counter.nJetons = 0;//initialise le compteur à zero
        NombreJetons.setText("");

        change = new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {
                if ("compteur".equals(evt.getPropertyName())) {
                    int progress = ((CompteurJetons) evt.getSource()).getProgres();
                    BarreProgres.setValue(progress);//met à jour la barre de progress
                    
                }
            }
        };

        Compteur.setEnabled(false);//désactive le bouton Compteur
        task = new Task();
        task.addPropertyChangeListener(change);
        task.execute();
    }//GEN-LAST:event_CompteurActionPerformed

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        // TODO add your handling code here:
        /*bouton annuler pour arreter le compte des jetons*/
        Compteur.setEnabled(true);//active le bouton compteur
        counter.annule = true;
        task.cancel(true);//on arrete l'action de compter le nombre de jetons
        NombreJetons.setText("Annulé");
    }//GEN-LAST:event_AnnulerActionPerformed

    private void FichierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FichierActionPerformed
        // TODO add your handling code here:
        /*Bouton Fichier pour selectionner un fichier*/
        Compteur.setEnabled(true);//active le bouton Compteur
        int returnValue = FileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            FileName = FileChooser.getSelectedFile().getName();//le nom du fichier selectionné
            FichierSelectionner = FileChooser.getSelectedFile();//le fichier selectionné
            CheminFichier.setText("" + FileName);
        }
        BarreProgres.setValue(0);//initialise la brre de progress et le compteur de jetons à zéro
        counter.nJetons = 0;
        NombreJetons.setText("");
    }//GEN-LAST:event_FichierActionPerformed


    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JProgressBar BarreProgres;
    private java.awt.TextField CheminFichier;
    private javax.swing.JButton Compteur;
    private javax.swing.JButton Fichier;
    private java.awt.Label NbrJetons;
    private javax.swing.JTextPane NombreJetons;
    private java.awt.Label Progres;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
