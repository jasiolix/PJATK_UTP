/**
 *
 *  @author Musiał Jan S28977
 *
 */

package Task1_TableOfCountries.src.src.zad1;


import javax.swing.*;

class Main {

  private JTable ctab;

  public void createTable(String countriesFileName) throws Exception {
    ctab = new CountryTable(countriesFileName).create();
  }

  public void showGui() {
    SwingUtilities.invokeLater( new Runnable() {
      public void run() {
        JFrame f = new JFrame("Countries table");
        f.add( new JScrollPane(ctab) );
        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
      }
    });
  }

  public static void main(String[] args)  {
    Main main = new Main();
    try {
      main.createTable("C:\\Users\\jasio\\Downloads\\UTP1_MJ_S28977\\UTP1_MJ_S28977\\src\\zad1\\countries.txt");
      main.showGui();
    } catch(Exception exc) {
      JOptionPane.showMessageDialog(null, "Table creation failed, " + exc);
    }
  }
}
