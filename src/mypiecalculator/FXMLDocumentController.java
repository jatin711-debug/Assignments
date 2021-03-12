package mypiecalculator;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FXMLDocumentController {
    
    @FXML
    private Button iterationValue;
    @FXML
    private Button precesionValue;
    @FXML
    private Button resultHolder;
    
    @FXML
    private void pieCalculator(){
        int iterations = Integer.parseInt(iterationValue.getText());
        int precesionVal = Integer.parseInt(precesionValue.getText());
        BigDecimal result = new BigDecimal("0"); // The result (summation of Taylor series) 
        BigDecimal oddNum = new BigDecimal("1"); // Odd numbers (1, 3, 5, 7 etc.) 
        BigDecimal pow5 = new BigDecimal("5"); // Odd powers of 5 (5^1, 5^3, 5^5 etc.) 
        BigDecimal pow239 = new BigDecimal("239"); // Odd powers of 239(239^1, 239^3, 239^5 etc.) 
        BigDecimal sign = new BigDecimal("1"); // Either 1 or -1 indicating the sign of the next term
        final BigDecimal val16 = new BigDecimal("16");
        final BigDecimal val4 = new BigDecimal("4");
        final MathContext precesion = new MathContext(precesionVal,RoundingMode.HALF_UP);
        
        for (int count = 0; count < iterations; count++) {
            BigDecimal nextTerm =  val16.divide(pow5.multiply(oddNum),precesion).subtract(val4.divide(pow239.multiply(oddNum),precesion)); 
            result = result.add(sign.multiply(nextTerm)) ;
            pow5 = pow5.multiply(new BigDecimal("25"),new MathContext(1000,RoundingMode.HALF_UP)); 
            pow239 = pow239.multiply(new BigDecimal("57121"),new MathContext(1000,RoundingMode.HALF_UP)); 
            oddNum = oddNum.add(new BigDecimal(2),new MathContext(1000,RoundingMode.HALF_UP)); 
            sign = sign.multiply(new BigDecimal(-1),new MathContext(1000,RoundingMode.HALF_UP)); 
        }
        
        resultHolder.setText(result.toString());
    }
       
    
}
