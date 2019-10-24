package gorjetas;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.rule.*;
import net.sourceforge.jFuzzyLogic.rule.*;
import java.util.Scanner;

public class Gorjetas {

   public static void main(String[] args) {
      Scanner ler = new  Scanner(System.in);
      
      String arquivo="C:\\Users\\Note\\Documents\\NetBeansProjects\\gorjetas\\src\\gorjetas\\gorjetas.fcl";
      FIS fis= FIS.load(arquivo,true);
      
      if(fis==null){
         System.out.println("ARQUIVO ERRADO");
         System.exit(1);
      }
      System.out.println("Aluno: Maicon Henrique Cordeiro Machado R.A->11716434");
      System.out.println("Qual a nota da comida (0-10) ->");
      double comida=ler.nextDouble();
      System.out.println("");
      
      System.out.println("Qual a nota do Serviço (0-10) ->");
      double servico=ler.nextDouble();
      System.out.println("");
      
      FunctionBlock fb = fis.getFunctionBlock(null);
      
      fb.setVariable("comida", comida);
      fb.setVariable("servico", servico);
      
      fb.evaluate();
      
      System.out.printf("O valor da gorjeta será de R$ %9.2f \n",
              fb.getVariable("gorjeta").getValue());
      System.out.println("\nApresentaçãoo das regras\n");
      
      for (Rule r
              : fis.getFunctionBlock("gorjetas").getFuzzyRuleBlock("No1").getRules()) {
         System.out.println(r);
      }
      
   }

}
