package zycus.assignment.utilities;

import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class OrederingFunctions implements IMethodInterceptor {
	static Logger log = Logger.getLogger(OrederingFunctions.class.getName());

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext paramITestContext) {
		log.info("=> ------calling ordering of functions-------- <=");
		methods.sort(new Comparator<IMethodInstance>() {

			@Override
			public int compare(IMethodInstance mi1, IMethodInstance mi2) {
				// log.info();
				Object obj1 = mi1.getInstance();
				Object obj2 = mi2.getInstance();
				if (obj1 instanceof AbstactcommonClass && obj2 instanceof AbstactcommonClass) {
					if (((AbstactcommonClass) obj1).getOrder() == ((AbstactcommonClass) obj2).getOrder()) {
						//System.out.println(((AbstactcommonClass) obj1).getOrder()+"   :----------------------it is the order----");
						return 0;
					} else if (((AbstactcommonClass) obj1).getOrder() > ((AbstactcommonClass) obj2).getOrder()) {
						//System.out.println(((AbstactcommonClass) obj1).getOrder()+"   :----------------------it is the order----");
						return 1;
					} else {
						//System.out.println(((AbstactcommonClass) obj1).getOrder()+"   :----------------------it is the order----");
						return -1;
					}
				} else {
					throw new ArithmeticException("Invalid Class");
				}

			}
			

		});

		
		log.info("=>: "+methods.size() + "   =>is the size of the test<=   ");
		for (IMethodInstance im : methods) {
			im.getInstance();
			//System.out.println(im.getMethod().getMethodName());
			//System.out.println(im.getMethod().getPriority());
		}
		return methods;
	}

}