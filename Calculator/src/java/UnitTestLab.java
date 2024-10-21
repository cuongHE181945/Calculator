import java.math.BigInteger;
import org.apache.log4j.Logger;

public class UnitTestLab {
    private final Logger logger = Logger.getLogger(UnitTestLab.class);
    
    public void logMsg(String msg) {
        logger.info(msg);
    }
    
    public BigInteger calcFactorial(int aNum) throws IllegalArgumentException {
        if (aNum < 1) {
            throw new IllegalArgumentException("Invalid input!");
        }

        BigInteger factorial = new BigInteger("1");
        for (int i = 2; i <= aNum; i++) {
            factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
        }
        return factorial;
    }
	
	public void printFactorial(int aNum) throws IllegalArgumentException {
        logMsg("number=" + aNum);
        if (aNum < 1) {
            logMsg("Invalid input!");
            throw new IllegalArgumentException("Invalid input!");
        }

        BigInteger factorial = new BigInteger("1");
        for (int i = 2; i <= aNum; i++) {
            factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
        }
        
        logMsg("factorial=" + factorial);
    }
	
	public long calcExtraFactorial(int a, int b) throws IllegalArgumentException {
        if (a < -10 || a == 0 || b <= -10 || b >= 10) {
            logMsg("Invalid input(s)!");
            throw new IllegalArgumentException("Invalid input(s)!");
        }

        if (a < 0) {
            logMsg("a negative");
            a = -1 * a;
        } else {
            logMsg("a positive");
        }

        if (b < 0) {
            logMsg("b negative");
        }

        return calcFactorial(a).longValueExact() / b;
    }
}