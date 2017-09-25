/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Airplane.Airplane;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Menita Koonani
 */
public class SearchJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SearchAirplaneJPanel
     */
    private int searchCriteria;

    public SearchJPanel() {
        initComponents();
        nextAvailFlightChooser.setMinSelectableDate(new Date(System.currentTimeMillis()));
        searchAirplaneQueryField.setVisible(false);
        searchAirplaneQueryLabel.setVisible(false);
        minSeatsField.setVisible(false);
        minSeatsQueryLabel.setVisible(false);
        maxSeatsQueryLabel.setVisible(false);
        maxSeatsField.setVisible(false);
        updateChangesBtn.setVisible(false);
    }

    public int getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(int searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public void setTextChanges() {
        searchAirplaneQueryField.setText("");
        switch (searchCriteria) {
            // by manufacture name
            case 3:
                searchAirplaneQueryLabel.setVisible(false);
                searchAirplaneQueryField.setVisible(false);
                break;
            // search by manufacture year
            case 4:
                searchAirplaneQueryLabel.setVisible(true);
                searchAirplaneQueryLabel.setText("Enter the manufacturer year to search: ");
                searchAirplaneQueryField.setVisible(true);
                break;
            // seat range availabilty
            case 5:
                minSeatsField.setVisible(true);
                minSeatsQueryLabel.setVisible(true);
                maxSeatsField.setVisible(true);
                maxSeatsQueryLabel.setVisible(true);
                break;
            // by serial number
            case 6:
                searchAirplaneQueryLabel.setText("Enter the serial number to search: ");
                searchAirplaneQueryLabel.setVisible(true);
                searchAirplaneQueryField.setVisible(true);
                break;
            // by model number
            case 7:
                searchAirplaneQueryLabel.setText("Enter the model number to search: ");
                searchAirplaneQueryLabel.setVisible(true);
                searchAirplaneQueryField.setVisible(true);
                break;
            // by airport name
            case 8:
                searchAirplaneQueryLabel.setText("Enter the airport name to search: ");
                searchAirplaneQueryLabel.setVisible(true);
                searchAirplaneQueryField.setVisible(true);
                break;
            // certificates expired airplanes
            case 9:
                searchPanelHeader.setText("List of airplanes having valid certificates!");
                break;
        }
    }

    public ArrayList<Airplane> searchByCriteria() {
        try {
            updateChangesBtn.setVisible(false);
            ArrayList<Airplane> airplaneList = new ArrayList();
            switch (searchCriteria) {
                // first available airplane
                case 1:
                    searchPanelHeader.setText("The first available airplane");
                    airplaneList = MainJFrame.airplaneCatalog.getFirstAvailableAirplane();
                    break;
                // available airplanes
                case 2:
                    searchPanelHeader.setText("List of available airplanes!");
                    airplaneList = MainJFrame.airplaneCatalog.getAvailableAirplanes(false);
                    break;
                // by manufacture name
                case 3:
                    searchAirplaneQueryLabel.setVisible(false);
                    searchAirplaneQueryField.setVisible(false);
                    String findManufacturer = "Boeing";
                    searchPanelHeader.setText("List of airplanes manufactured by " + findManufacturer);
                    airplaneList = MainJFrame.airplaneCatalog.getAirplaneManufacturer(findManufacturer, false);
                    break;
                // by manufactured year
                case 4:
                    int findYear = Integer.parseInt(searchAirplaneQueryField.getText());
                    searchPanelHeader.setText("List of airplanes manufactured in " + findYear);
                    airplaneList = MainJFrame.airplaneCatalog.getAiplaneByManuYear(findYear);
                    break;
                // seat range availabilty
                case 5:
                    searchPanelHeader.setText("List of airplanes in the specified seat range!");
                    int minSeats = minSeatsField.getValue();
                    int maxSeats = maxSeatsField.getValue();
                    airplaneList = MainJFrame.airplaneCatalog.getAirplanesBySeatRange(minSeats, maxSeats);
                    break;
                // by serial number
                case 6:
                    Long findSerialNum = Long.parseLong(searchAirplaneQueryField.getText());
                    searchPanelHeader.setText("Airplanes having the serial number " + findSerialNum);
                    airplaneList = MainJFrame.airplaneCatalog.getAirplaneBySerialNum(findSerialNum);
                    break;
                // by model number
                case 7:
                    String findModelNum = searchAirplaneQueryField.getText();
                    searchPanelHeader.setText("List of airplanes whose model number is  " + findModelNum);
                    airplaneList = MainJFrame.airplaneCatalog.getAirplaneByModelNum(findModelNum);
                    break;
                // by airport name
                case 8:
                    String findAirport = searchAirplaneQueryField.getText();
                    searchPanelHeader.setText("List of airplanes in " + findAirport);
                    airplaneList = MainJFrame.airplaneCatalog.getAirplaneByAirport(findAirport, false);
                    break;
                // certificates expired airplanes
                case 9:
                    searchPanelHeader.setText("List of airplanes having valid certificates!");
                    airplaneList = MainJFrame.airplaneCatalog.getValidCertiAirplanes();
                    break;
            }
            if (airplaneList == null || airplaneList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No airplanes matched this search!");
            } else {
                searchResultCountField.setText(String.valueOf(airplaneList.size()));
            }
            return airplaneList;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter only numbers!!");
        }
        return null;
    }

    public void populateTable(ArrayList<Airplane> airplaneList) {
        DefaultTableModel airplaneTable = (DefaultTableModel) searchAirplaneTable.getModel();
        airplaneTable.setNumRows(0);
        //starting the population form row 0
        airplaneTable.setRowCount(0);
        for (Airplane eachAirplane : airplaneList) {
            Object row[] = new Object[3];
            //setting the object to the first row as we need to access all the other attributes of that particular object
            row[0] = eachAirplane;
            row[1] = eachAirplane.getAirplaneName();
            row[2] = eachAirplane.getSeatsAvailable();
            airplaneTable.addRow(row);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        availBtnGroup = new javax.swing.ButtonGroup();
        expiryBtnGroup = new javax.swing.ButtonGroup();
        searchAirplaneQueryField = new javax.swing.JTextField();
        chooseCategroyLabel = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        searchPanelHeader = new javax.swing.JLabel();
        searchScrollPane = new javax.swing.JScrollPane();
        searchAirplaneTable = new javax.swing.JTable();
        viewDetailsBtn = new javax.swing.JButton();
        searchResultCountLabel = new javax.swing.JLabel();
        searchResultCountField = new javax.swing.JTextField();
        serialNumberLabel = new javax.swing.JLabel();
        serailNumberField = new javax.swing.JTextField();
        modelNumberLabel = new javax.swing.JLabel();
        modelNumberField = new javax.swing.JTextField();
        airplaneNameLabel = new javax.swing.JLabel();
        airplaneNameField = new javax.swing.JTextField();
        airplaneAvailableLabel = new javax.swing.JLabel();
        manufacturerNameLabel = new javax.swing.JLabel();
        manufacturerNameField = new javax.swing.JTextField();
        yearManuLabel = new javax.swing.JLabel();
        seatsAvailLabel = new javax.swing.JLabel();
        airportNameLabel = new javax.swing.JLabel();
        airportNameField = new javax.swing.JTextField();
        updateAirplaneBtn = new javax.swing.JButton();
        planeAvailable = new javax.swing.JCheckBox();
        planeUnavailable = new javax.swing.JCheckBox();
        yearManuChooser = new com.toedter.calendar.JYearChooser();
        seatsAvailChooser = new com.toedter.components.JSpinField();
        updateChangesBtn = new javax.swing.JButton();
        airplaneAvailableLabel1 = new javax.swing.JLabel();
        invalidCertificate = new javax.swing.JRadioButton();
        validCertificate = new javax.swing.JRadioButton();
        minSeatsQueryLabel = new javax.swing.JLabel();
        minSeatsField = new com.toedter.components.JSpinField();
        maxSeatsField = new com.toedter.components.JSpinField();
        maxSeatsQueryLabel = new javax.swing.JLabel();
        nextAvailFlightLabel = new javax.swing.JLabel();
        nextAvailFlightChooser = new com.toedter.calendar.JDateChooser();
        airlinerNameLabel = new javax.swing.JLabel();
        airlinerNameField = new javax.swing.JTextField();
        searchComboBox = new javax.swing.JComboBox<>();
        searchAirplaneQueryLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(searchAirplaneQueryField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 198, -1));

        chooseCategroyLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        chooseCategroyLabel.setText("Choose search category:");
        chooseCategroyLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add(chooseCategroyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 310, 20));

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, -1));

        searchPanelHeader.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        searchPanelHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchPanelHeader.setText("Airplane Details");
        searchPanelHeader.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add(searchPanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 610, -1));

        searchAirplaneTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airplane Serial Number", "Airplane Name", "Seats available"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        searchScrollPane.setViewportView(searchAirplaneTable);

        add(searchScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, 140));

        viewDetailsBtn.setText("View Details");
        viewDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsBtnActionPerformed(evt);
            }
        });
        add(viewDetailsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, -1, -1));

        searchResultCountLabel.setText("Number of Airplanes found: ");
        add(searchResultCountLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 160, 20));

        searchResultCountField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchResultCountFieldActionPerformed(evt);
            }
        });
        add(searchResultCountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 55, -1));

        serialNumberLabel.setText("Airplane Serial  Number:");
        add(serialNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, -1, -1));

        serailNumberField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(serailNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, 143, -1));

        modelNumberLabel.setText("Airplane Model Number:");
        add(modelNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, -1, -1));
        add(modelNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, 143, -1));

        airplaneNameLabel.setText("Airplane Name:");
        add(airplaneNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, -1, -1));
        add(airplaneNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 143, -1));

        airplaneAvailableLabel.setText("Is the airplane available:");
        add(airplaneAvailableLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 410, -1, -1));

        manufacturerNameLabel.setText("Airplane manufacturer name:");
        add(manufacturerNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, -1, -1));

        manufacturerNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manufacturerNameFieldActionPerformed(evt);
            }
        });
        add(manufacturerNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 470, 143, -1));

        yearManuLabel.setText("Year of manufacture:");
        add(yearManuLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 290, -1, -1));

        seatsAvailLabel.setText("Number of seats available:");
        add(seatsAvailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 330, -1, -1));

        airportNameLabel.setText("Airport Name:");
        add(airportNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, -1, -1));
        add(airportNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, 143, -1));

        updateAirplaneBtn.setText("Update");
        updateAirplaneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAirplaneBtnActionPerformed(evt);
            }
        });
        add(updateAirplaneBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 230, 101, -1));

        availBtnGroup.add(planeAvailable);
        planeAvailable.setSelected(true);
        planeAvailable.setText("Yes");
        planeAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planeAvailableActionPerformed(evt);
            }
        });
        add(planeAvailable, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 410, -1, -1));

        availBtnGroup.add(planeUnavailable);
        planeUnavailable.setText("No");
        add(planeUnavailable, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 410, -1, -1));

        yearManuChooser.setEndYear(2017);
        yearManuChooser.setMinimum(1990);
        yearManuChooser.setName("yearOfManu"); // NOI18N
        add(yearManuChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 290, 67, -1));

        seatsAvailChooser.setMaximum(550);
        seatsAvailChooser.setMinimum(0);
        seatsAvailChooser.setName("seatsAvailable"); // NOI18N
        seatsAvailChooser.setValue(550);
        add(seatsAvailChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 330, 67, -1));

        updateChangesBtn.setText("Update changes");
        updateChangesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateChangesBtnActionPerformed(evt);
            }
        });
        add(updateChangesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 500, -1, -1));

        airplaneAvailableLabel1.setText("Certificate expired:");
        add(airplaneAvailableLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 370, -1, -1));

        expiryBtnGroup.add(invalidCertificate);
        invalidCertificate.setText("Yes");
        add(invalidCertificate, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 370, -1, -1));

        expiryBtnGroup.add(validCertificate);
        validCertificate.setSelected(true);
        validCertificate.setText("No");
        validCertificate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validCertificateActionPerformed(evt);
            }
        });
        add(validCertificate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 370, -1, -1));

        minSeatsQueryLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        minSeatsQueryLabel.setText("Enter minimum seats:");
        minSeatsQueryLabel.setName("minSeatsLabel"); // NOI18N
        add(minSeatsQueryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        minSeatsField.setMaximum(550);
        minSeatsField.setMinimum(1);
        minSeatsField.setName("minSeatsField"); // NOI18N
        minSeatsField.setOpaque(false);
        minSeatsField.setValue(1);
        minSeatsField.setVerifyInputWhenFocusTarget(false);
        add(minSeatsField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 66, -1));

        maxSeatsField.setMaximum(550);
        maxSeatsField.setMinimum(1);
        maxSeatsField.setName("maxSeatsField"); // NOI18N
        maxSeatsField.setOpaque(false);
        maxSeatsField.setValue(550);
        add(maxSeatsField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 66, -1));

        maxSeatsQueryLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        maxSeatsQueryLabel.setText("Enter maximum seats:");
        maxSeatsQueryLabel.setName("maxSeatsLabel"); // NOI18N
        add(maxSeatsQueryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        nextAvailFlightLabel.setText("Next available Date:");
        add(nextAvailFlightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, -1, -1));
        add(nextAvailFlightChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 450, 160, -1));

        airlinerNameLabel.setText("Airliner Name:");
        add(airlinerNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, -1, -1));
        add(airlinerNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, 143, -1));

        searchComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Search first available airplane", "List currently available airplanes", "List of airplanes by Boeing", "Search by manufacture year", "Search by seat availability", "Search by serial number", "Search by model number", "Search by airport name", "List airplanes having expired maintanence certificate", "" }));
        searchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchComboBoxActionPerformed(evt);
            }
        });
        add(searchComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 250, 30));

        searchAirplaneQueryLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        searchAirplaneQueryLabel.setText("Enter search query:");
        searchAirplaneQueryLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add(searchAirplaneQueryLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 310, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        this.searchCriteria = searchComboBox.getSelectedIndex() + 1;
        ArrayList<Airplane> searchResultList = searchByCriteria();
        populateTable(searchResultList);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void viewDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsBtnActionPerformed
        // TODO add your handling code here
        updateChangesBtn.setVisible(false);
        fillIntoFields();
        isEditable(false);
    }//GEN-LAST:event_viewDetailsBtnActionPerformed
    public void fillIntoFields() {
        int selectedRow = searchAirplaneTable.getSelectedRow();
//        selectedRow = selectedRow >= 0 ? selectedRow : (searchAirplaneTable.getRowCount() == 1 ? 0 : -1);
        if (selectedRow >= 0) {
            Airplane airplane = (Airplane) searchAirplaneTable.getValueAt(selectedRow, 0);
            serailNumberField.setText(String.valueOf(airplane.getSerialNumber()));
            modelNumberField.setText(String.valueOf(airplane.getModelNumber()));
            airlinerNameField.setText(String.valueOf(airplane.getAirlinerName()));
            airplaneNameField.setText(String.valueOf(airplane.getAirplaneName()));
            if (airplane.isAvailable()) {
                planeAvailable.setSelected(true);
            } else {
                planeUnavailable.setSelected(true);
            }
            manufacturerNameField.setText(String.valueOf(airplane.getManufacturerName()));
            yearManuChooser.setYear(airplane.getYearOfManufacture());
            seatsAvailChooser.setValue(airplane.getSeatsAvailable());
            airportNameField.setText(String.valueOf(airplane.getAirportName()));
            validCertificate.setSelected(airplane.isCertitficateValid());
            invalidCertificate.setSelected(!airplane.isCertitficateValid());
            nextAvailFlightChooser.setDate(airplane.getNextAvailableDate());

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row!!");
        }
    }

    public void isEditable(boolean isEditable) {
        serailNumberField.setEditable(isEditable);
        modelNumberField.setEditable(isEditable);
        airplaneNameField.setEditable(isEditable);
        serailNumberField.setEditable(isEditable);
        airportNameField.setEditable(isEditable);
        airlinerNameField.setEditable(isEditable);
        manufacturerNameField.setEditable(isEditable);

        planeAvailable.setEnabled(isEditable);
        planeUnavailable.setEnabled(isEditable);
        yearManuChooser.setEnabled(isEditable);
        seatsAvailChooser.setEnabled(isEditable);
        validCertificate.setEnabled(isEditable);
        invalidCertificate.setEnabled(isEditable);
        nextAvailFlightChooser.setEnabled(isEditable);
    }

    private void searchResultCountFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchResultCountFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchResultCountFieldActionPerformed

    private void updateAirplaneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAirplaneBtnActionPerformed
        // TODO add your handling code here:
        updateChangesBtn.setVisible(true);
        fillIntoFields();
        isEditable(true);
    }//GEN-LAST:event_updateAirplaneBtnActionPerformed

    private void updateChangesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateChangesBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = searchAirplaneTable.getSelectedRow();
        if (selectedRow >= 0) {
            Airplane airplane = (Airplane) searchAirplaneTable.getValueAt(selectedRow, 0);
            getViewFieldsFromPanel(airplane);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row!!");
        }
    }//GEN-LAST:event_updateChangesBtnActionPerformed

    private void manufacturerNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manufacturerNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manufacturerNameFieldActionPerformed

    private void planeAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planeAvailableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_planeAvailableActionPerformed

    private void validCertificateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validCertificateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_validCertificateActionPerformed

    private void searchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchComboBoxActionPerformed
        // TODO add your handling code here:
        this.searchCriteria = searchComboBox.getSelectedIndex() + 1;
        setTextChanges();
    }//GEN-LAST:event_searchComboBoxActionPerformed

    public void getViewFieldsFromPanel(Airplane airplane) {
        try {
            airplane.setSerialNumber(Long.parseLong(serailNumberField.getText()));
            airplane.setModelNumber(modelNumberField.getText());
            airplane.setAirlinerName(airlinerNameField.getText());
            airplane.setAirplaneName(airplaneNameField.getText());
            airplane.setIsAvailable(planeAvailable.isSelected());
            airplane.setManufacturerName(manufacturerNameField.getText());
            airplane.setYearOfManufacture(yearManuChooser.getYear());
            airplane.setSeatsAvailable(seatsAvailChooser.getValue());
            airplane.setAirportName(airportNameField.getText());
            airplane.setIsCertificateValid(validCertificate.isSelected());
            airplane.setNextAvailableDate(nextAvailFlightChooser.getDate());

            JOptionPane.showMessageDialog(null, "Updated!!");
            resetViewFields();
            isEditable(false);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Serial Number : Serial Number field can contian only numbers!! Please try again!");
            serailNumberField.requestFocus();
        }
    }

    public void resetViewFields() {
        serailNumberField.setText("");
        modelNumberField.setText("");
        airplaneNameField.setText("");
        planeAvailable.setSelected(true);
        manufacturerNameField.setText("");
        yearManuChooser.setYear(2017);
        seatsAvailChooser.setValue(550);
        airportNameField.setText("");
        airlinerNameField.setText("");
        nextAvailFlightChooser.setDate(new Date(System.currentTimeMillis()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField airlinerNameField;
    private javax.swing.JLabel airlinerNameLabel;
    private javax.swing.JLabel airplaneAvailableLabel;
    private javax.swing.JLabel airplaneAvailableLabel1;
    private javax.swing.JTextField airplaneNameField;
    private javax.swing.JLabel airplaneNameLabel;
    private javax.swing.JTextField airportNameField;
    private javax.swing.JLabel airportNameLabel;
    private javax.swing.ButtonGroup availBtnGroup;
    private javax.swing.JLabel chooseCategroyLabel;
    private javax.swing.ButtonGroup expiryBtnGroup;
    private javax.swing.JRadioButton invalidCertificate;
    private javax.swing.JTextField manufacturerNameField;
    private javax.swing.JLabel manufacturerNameLabel;
    private com.toedter.components.JSpinField maxSeatsField;
    private javax.swing.JLabel maxSeatsQueryLabel;
    private com.toedter.components.JSpinField minSeatsField;
    private javax.swing.JLabel minSeatsQueryLabel;
    private javax.swing.JTextField modelNumberField;
    private javax.swing.JLabel modelNumberLabel;
    private com.toedter.calendar.JDateChooser nextAvailFlightChooser;
    private javax.swing.JLabel nextAvailFlightLabel;
    private javax.swing.JCheckBox planeAvailable;
    private javax.swing.JCheckBox planeUnavailable;
    private javax.swing.JTextField searchAirplaneQueryField;
    private javax.swing.JLabel searchAirplaneQueryLabel;
    private javax.swing.JTable searchAirplaneTable;
    private javax.swing.JButton searchBtn;
    private javax.swing.JComboBox<String> searchComboBox;
    private javax.swing.JLabel searchPanelHeader;
    private javax.swing.JTextField searchResultCountField;
    private javax.swing.JLabel searchResultCountLabel;
    private javax.swing.JScrollPane searchScrollPane;
    private com.toedter.components.JSpinField seatsAvailChooser;
    private javax.swing.JLabel seatsAvailLabel;
    private javax.swing.JTextField serailNumberField;
    private javax.swing.JLabel serialNumberLabel;
    private javax.swing.JButton updateAirplaneBtn;
    private javax.swing.JButton updateChangesBtn;
    private javax.swing.JRadioButton validCertificate;
    private javax.swing.JButton viewDetailsBtn;
    private com.toedter.calendar.JYearChooser yearManuChooser;
    private javax.swing.JLabel yearManuLabel;
    // End of variables declaration//GEN-END:variables
}
