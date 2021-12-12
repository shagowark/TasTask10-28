package JFrameModule;

import LogicModule.AdvertFilter;
import LogicModule.Apartment;
import LogicModule.Logic;
import Utils.JTableUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Frame extends JFrame{

    private JPanel panelMain;
    private JButton loadInputFromFileButton;
    private JButton getSolutionButton;
    private JButton saveOutputIntoFile;
    private JTable tableInput;
    private JTable tableOutput;
    private JTable tableFilter;

    private final JFileChooser fileChooserOpen;
    private final JFileChooser fileChooserSave;

    public Frame() {
        this.setTitle("Task10(28)");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panelMain);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 40, true, true, true, false);
        JTableUtils.resizeJTable(tableInput, 1,5, 30, 70);
        setHeadersNames(tableInput);

        JTableUtils.initJTableForArray(tableOutput, 40, true, true, false, false);
        JTableUtils.resizeJTable(tableOutput, 1,5, 30, 70);
        setHeadersNames(tableOutput);

        JTableUtils.initJTableForArray(tableFilter, 40, true, true, false, false);
        JTableUtils.resizeJTable(tableFilter, 1, 8, 30, 100);
        tableFilter.getColumnModel().getColumn(0).setHeaderValue("Мин. комнат");
        tableFilter.getColumnModel().getColumn(1).setHeaderValue("Макс. комнат");
        tableFilter.getColumnModel().getColumn(2).setHeaderValue("Мин. площадь");
        tableFilter.getColumnModel().getColumn(3).setHeaderValue("Макс. площадь");
        tableFilter.getColumnModel().getColumn(4).setHeaderValue("Мин. кухня");
        tableFilter.getColumnModel().getColumn(5).setHeaderValue("Макс. кухня");
        tableFilter.getColumnModel().getColumn(6).setHeaderValue("Мин. цена");
        tableFilter.getColumnModel().getColumn(7).setHeaderValue("Макс. цена");



        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        this.setVisible(true);
        this.setSize(860, 350);

        loadInputFromFileButton.addActionListener(e -> {
            try {
                if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    ArrayList<Apartment> apartsList = new ArrayList<>(Logic.readApartsListFromFile(fileChooserOpen.getSelectedFile().getPath()));
                    Logic.checkIfArrayListIsNull(apartsList);
                    Logic.checkIfArrayListIsEmpty(apartsList);
                    writeApartsIntoJTable(tableInput, apartsList);
                }
            } catch (Exception ex) {
                displayError("Пустой input файл");
            }
        });

        getSolutionButton.addActionListener(e -> {
            try {
                ArrayList<Apartment> apartsList = new ArrayList<>(Logic.readApartsListFromJtable(tableInput));
                int[] filterArgs = JTableUtils.readIntArrayFromJTable(tableFilter);
                AdvertFilter adFilter = new AdvertFilter(filterArgs[0], filterArgs[1], filterArgs[2],
                        filterArgs[3], filterArgs[4], filterArgs[5], filterArgs[6], filterArgs[7]);
                ArrayList<Apartment> goodAparts = new ArrayList<>(Logic.filterAparts(apartsList, adFilter));
                Logic.checkIfArrayListIsEmpty(goodAparts);
                writeApartsIntoJTable(tableOutput, goodAparts);
            }
            catch (NoSuchElementException ex){
                displayMessage("Нет подходящих квартир");
            }
            catch (Exception ex){
                displayError("Ошибка в исходных данных");
            }
        });



        saveOutputIntoFile.addActionListener(e -> {
            try {
                if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    ArrayList<Apartment> goodAparts = new ArrayList<>(Logic.readApartsListFromJtable(tableOutput));
                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".txt")) {
                        file += ".txt";
                    }
                    Logic.saveOutputIntoFile(file, goodAparts);
                }
            } catch (Exception ex) {
               displayError("Ошибка при попытке сохранить файл");
            }
        });


    }

    private void displayError(String errorText) {
        JOptionPane.showMessageDialog(this, errorText,
                "Ошибка", JOptionPane.ERROR_MESSAGE);
    }
    private void displayMessage(String messageText) {
        JOptionPane.showMessageDialog(this, messageText,
                "Сообщение", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setHeadersNames(JTable table){
        table.getColumnModel().getColumn(0).setHeaderValue("Район");
        table.getColumnModel().getColumn(1).setHeaderValue("Комнаты");
        table.getColumnModel().getColumn(2).setHeaderValue("Площадь");
        table.getColumnModel().getColumn(3).setHeaderValue("Кухня");
        table.getColumnModel().getColumn(4).setHeaderValue("Цена");
    }

    public void writeApartsIntoJTable(JTable table, ArrayList<Apartment> apartsList){
        JTableUtils.resizeJTable(table, apartsList.size(),5, 30, 70);
        setHeadersNames(table);
        for (int i = 0; i < table.getRowCount(); i++){
            Apartment apart = apartsList.get(i);
            table.setValueAt(apart.getDistrict(), i, 0);
            table.setValueAt(apart.getRoomsNumber(), i, 1);
            table.setValueAt(apart.getArea(), i, 2);
            table.setValueAt(apart.getKitchenArea(), i, 3);
            table.setValueAt(apart.getPrice(), i, 4);
        }
    }
}

