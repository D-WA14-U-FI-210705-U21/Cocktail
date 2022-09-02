/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Rebecca Röller
 */
    public class AutoCompleteComboBox extends JComboBox{
    public int pos = 0;
    public JTextField tfield = null;
    
    @Override
    public void setSelectedIndex(int index) {
      super.setSelectedIndex(index);
      tfield.setText(getItemAt(index).toString());
      tfield.setSelectionEnd(pos + tfield.getText().length());
      tfield.moveCaretPosition(pos);
    }
    @Override
    public void setEditor(ComboBoxEditor editor){
        super.setEditor(editor);
        if(editor.getEditorComponent()instanceof JTextField){
            tfield = (JTextField)editor.getEditorComponent();
            tfield.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent key){
                char ch = key.getKeyChar();
                 if (!(Character.isLetterOrDigit(key.getKeyChar()) || Character.isSpaceChar(key.getKeyChar()) )) return;
                pos = tfield.getCaretPosition();
                String text="";
                try {
                  text = tfield.getText(0, pos);
               } catch (javax.swing.text.BadLocationException ex) {
                    System.out.println(ex.getMessage());
               }
                for (int i=0; i < getItemCount(); i++) {
                  String element = (String) getItemAt(i);
                  if (element.startsWith(text)) {
                     setSelectedIndex(i);
                     return;
                  }
            }
        }
        });
    }
    }
    }

