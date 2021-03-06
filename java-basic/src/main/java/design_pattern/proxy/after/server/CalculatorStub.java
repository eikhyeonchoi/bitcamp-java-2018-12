package design_pattern.proxy.after.server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

// 클라이언트의 요청을 서버에 전달하고 서버의 작업 결과를 클라이언트에게 return하는역할 
// ==> 즉 객체(Calculator class)와 클라이언트간의 중계 역할을 수행한다
// ==> 이렇게 원격에서 객체를 사용할 수 있도록 중계인의 역할을 수행하는 객체를
//    Object Request Broker(ORB) 라고한다
// ==> 객체가 있는 서버측에서 요청과 응답을 대행하는 ORB를 "스켈레톤(skeleton)"이라고 부른다
// ==> 객체를 사용하는 클라이언트 측에서 요청과 응답을 대행하는 ORB를 "스텁(stub)"이라고 부른다
//
// 스텁은 실제 일을 하는 객체를 대행하기 때문에 같은 규칙에 따라 구현되어야 한다
// 클라이언트는 이 스텁 클래스가 실제 일을 하는 객체인양 그대로 사용 한다
// ==> 이렇게 실제 일을 하는 객체와 같은 규칙을 따르지만, 메서드가 호출될 때
//     자신이 직접 일을 하지 않고 실제 일을 하는 객체에게 위임
//     이런 식으로 설계하는 것을 proxy라고한다
public class CalculatorStub implements Calculator{
  
  private int compute(int a, int b, String op) throws Exception {
    try (Socket socket = new Socket("localhost", 8888);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream()); ){

      out.writeInt(a);
      out.writeInt(b);
      out.writeUTF(op);

      if(in.readUTF().equalsIgnoreCase("OK")) {
        return in.readInt();
      } else {
        throw new RuntimeException(in.readUTF());
      }
      
    } // try with resources
  } // compute()

  
  @Override
  public int plus(int a, int b) {
    try {
    return compute(a, b, "+");
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  } // plus()

  
  @Override
  public int minus(int a, int b) {
    try {
      return compute(a, b, "-");
    } catch(Exception e) {
      throw new RuntimeException(e);
    } 
  } // minus()
  
  
} // end of class
