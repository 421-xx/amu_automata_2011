package pl.edu.amu.wmi.daut.re;
import java.util.Stack;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import pl.edu.amu.wmi.daut.base.AutomatonSpecification;

public class RegexpUtilities {

	static AutomatonSpecification createAutopmatonFromOperatorTree (RegexpOperatorTree tree) throws RuntimeException
	{
            //przejd� przez drzewo stan�w metod� post-order, przy pomocy dw�ch stos�w.
            Stack<RegexpOperatorTree> child = new Stack<RegexpOperatorTree>();
            Stack<RegexpOperatorTree> parent = new Stack<RegexpOperatorTree>();
            child.push(tree);
            while (!child.empty())
            {
                RegexpOperatorTree current = child.peek();
                parent.push(current);
                child.pop();
                
                for (RegexpOperatorTree subTree : current.getSubtrees())
                    child.push(subTree);
            }
            
            //na stosie "parent" mamy teraz wierzcho�ki w porz�dku post-order!
            //w porz�dku post-order chodzi o to, �e zawsze zaczynamy od nieodwiedzonych li�ci
            //i idziemy powoli w kierunku korzenia drzewa.
            
            //utw�rz map� poddrzew na automaty przez nich utworzone.
            Map<RegexpOperatorTree, AutomatonSpecification> map = new HashMap<RegexpOperatorTree, AutomatonSpecification>();
            
            while (!parent.empty())
            {
                RegexpOperatorTree current = parent.peek();
                
                //utw�rz list� automat�w utworzonych przez syn�w wierzcho�ka.
                List<AutomatonSpecification> arguments = new ArrayList<AutomatonSpecification>();
                for (RegexpOperatorTree subTree : current.getSubtrees())
                {
                    //nie b�dzie tutaj odwo�ania do nieistniej�cych kluczy ze
                    //wzgl. na charakter porz�dku post-order. je�li wyst�pi tutaj
                    //exception, to znaczy, �e �le zaimplementowali�my co� wcze�niej.
                    AutomatonSpecification subTreeAutomaton = map.get(subTree);
                    arguments.add(subTreeAutomaton);
                }
                
                //utw�rz automat, kt�rego argumentami s� automaty wszystkich syn�w.
                AutomatonSpecification currentAutomaton = current.getRoot().createAutomaton(arguments);
                //zapami�taj automat dla danego wierzcho�ka. poniewa� li�cie si�
                //wykonaj� "najpierw", to nadchodz�cy po tym rodzice tych li�ci
                //b�d� mieli pe�n� informacj� o automatach utworzonych przez 
                //swoich syn�w...
                map.put(current, currentAutomaton);
                
                parent.pop();
                
                //usun�li�my w�a�nie wierzcho�ek-korze� - zostali�my z pustym stosem, mo�emy zwr�ci� automat.
                if (parent.empty())
                    return currentAutomaton;
            }

            //ten kod nie powinien si� nigdy wykona�.
            throw new RuntimeException("");
    }
}
