import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BalancedBracketsTest {
    
    BalancedBrackets blbr = new BalancedBrackets();
    
    @Test
    public void testBalancedBrackets_BalancedParen(){
        assertTrue(blbr.hasBalancedBrackets("()"));
    }
        
    @Test
    public void testBalancedBrackets_ExtraAngleBracket(){
        assertFalse(blbr.hasBalancedBrackets("({[<]})"));
    }
        
    @Test
    public void testBalancedBrackets_ExtraCurlyBracket(){
        assertFalse(blbr.hasBalancedBrackets("(}())"));
    }
        
    @Test
    public void testBalancedBrackets_MixedBrackets(){
        assertFalse(blbr.hasBalancedBrackets("({<}>)"));
    }
    
    @Test
    public void testBalancedBrackets_BalancedParenExtraChars(){
        assertTrue(blbr.hasBalancedBrackets("(tgh)jjj"));
    }

}
