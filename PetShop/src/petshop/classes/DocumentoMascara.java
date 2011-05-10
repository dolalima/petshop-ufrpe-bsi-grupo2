/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package petshop.classes;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class DocumentoMascara extends PlainDocument {

    private int tamanhoMaximo;

    public DocumentoMascara(int maxlen) {
        super();
        tamanhoMaximo = maxlen;
    }
    
    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {

        if(tamanhoMaximo <= 0) {// aceitara qualquer no. de caracteres
            super.insertString(offset, str.toUpperCase(), attr);
            return;
        }

        int ilen = (getLength() + str.length());
        if(ilen <= tamanhoMaximo) {// se o comprimento final for menor...
            super.insertString(offset, str.toUpperCase(), attr);
        }
    }

    public int getTamanhoMaximo() {
        return tamanhoMaximo;
    }

    public void setTamanhoMaximo(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
    }
}
