package CustomListeners;

import org.testng.*;

import java.beans.ExceptionListener;

public class TestngListeners implements IInvokedMethodListener, ITestListener , IExecutionListener ,IRetryAnalyzer{

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

            System.out.println( method.getTestMethod().getMethodName()+"started");
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

            System.out.println( method.getTestMethod().getMethodName()+"finished");
    }
    @Override
    public void onTestSuccess(ITestResult result)
    {
        System.out.println(result.getMethod().getMethodName()+"passed");
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        System.out.println(result.getMethod().getMethodName()+"failed");
    }
    @Override
    public void onTestSkipped(ITestResult result)
    {
        System.out.println(result.getMethod().getMethodName()+"Skip");
    }
    @Override
    public void onExecutionStart()
    {
      System.out.println("Executuion started"
      );
    }
    @Override
    public void onExecutionFinish()
    {
      System.out.println("Execution Finshed");
    }

     private int attemps=0;
    @Override
    public boolean retry(ITestResult iTestResult)
    {
       if(iTestResult.getStatus()==ITestResult.FAILURE && attemps==0)
       {
           attemps++;
           return true;
       }
       return false;
    }
}

