package GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GANTTChart.GanttChart;

import core.Driver;
import core.Project;
import core.Task;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Derek
 */
public class BrowseTasksWindow extends javax.swing.JFrame {

    /**
     * Creates new form BrowseTasksWindow
     */
    public BrowseTasksWindow() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        buttonGANTT = new javax.swing.JButton();
        criticalPathButton = new javax.swing.JButton();
        projectTasks = Driver.getCurrentProject().getTasks();
        

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);    
        updateListDisplay();

       
        jScrollPane1.setViewportView(jList1);

        jToolBar1.setRollover(true);

        jButton1.setText("Add Task");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);
        
        //JButton1 Action Create Task
        jButton1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		                                     
        		Driver.createTask();
        		projectTasks = Driver.getCurrentProject().getTasks();
        		updateListDisplay();
      	  }
        });

        jButton2.setText("Edit Task");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);
        jButton2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        
		        projectTasks = Driver.getCurrentProject().getTasks();
				updateListDisplay();
        	}
        });

        //Delete Task Button
        jButton3.setText("Delete Task");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton3);
        jButton3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		int dialogButton = JOptionPane.YES_NO_OPTION;
        		int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this task?", "Confirm Delete",dialogButton);
        		if(dialogResult==0){
	        		Task temp = (Task)jList1.getSelectedValue();
	        		temp.deleteTask();
			        projectTasks = Driver.getCurrentProject().getTasks();
			        updateListDisplay();
        		}
				
        	}
        });
        
        //Jbutton display GANTT Chart
        buttonGANTT.setText("Display GANTT Chart");
        buttonGANTT.setFocusable(false);
        buttonGANTT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonGANTT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonGANTT.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evt){
        		Project temp = Driver.getCurrentProject();
        		GanttChart chart = new GanttChart();
        		chart.GANTTAnalysis(temp);
        	}
        });
        jToolBar1.add(buttonGANTT);
        
        //CriticalPathButton
        criticalPathButton.setText("CriticalPath Analysis");
        criticalPathButton.setFocusable(false);
        criticalPathButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        criticalPathButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        

        //CriticalPathActionPerformed
        criticalPathButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent evt){
        		ArrayList<String> temp = Driver.getCurrentProject().criticalPath();
        		StringBuilder sb = new StringBuilder();
        		for(String s : temp ){
        			sb.append(s);
        			sb.append(", ");
        		}
        		JOptionPane.showMessageDialog(null, sb.toString());		
        	}
        }); 
        jToolBar1.add(criticalPathButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(BrowseTasksWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrowseTasksWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrowseTasksWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrowseTasksWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BrowseTasksWindow().setVisible(true);
            }
        });
    }
    
    public void updateListDisplay(){
   	 final DefaultListModel model = new DefaultListModel();
   	 if(projectTasks.size() != 0){
	   	 for(int i = 0; i < projectTasks.size(); i++){
	   		 model.addElement(projectTasks.get(i));
	   	 }
	   	 jList1.setModel(model);
   	 }
   	
   }

    // Variables declaration - do not modify 
    private javax.swing.JButton criticalPathButton;
    private javax.swing.JButton buttonGANTT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private ArrayList<Task> projectTasks;
    // End of variables declaration                   
}