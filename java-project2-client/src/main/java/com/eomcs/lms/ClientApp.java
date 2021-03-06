package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class ClientApp {

  Scanner keyboard = new Scanner(System.in);
  Stack<String> commandHistory = new Stack<>();
  Queue<String> commandHistory2 = new LinkedList<>();

  public void service() throws Exception {
    while (true) {

      String input = prompt();

      if (input.equals("quit")) {
        System.out.println("클라이언트를 종료합니다");
        return;
      } 
      commandHistory.push(input);
      commandHistory2.offer(input);

      if (input.equals("history")) {
        printCommandHistory();
        continue;
      } else if (input.equals("history2")) {
        printCommandHistory2();
        continue;
      } 

      // 예) localhost:8888/board/list
      int index = input.indexOf("/"); // ==> localhost:8888 처음포함 끝 미포함
      String[] values = input.substring(0, index).split(":");
      // values[0] ==> localhost
      // values[1] ==> 8888
      String host = values[0];
      int port = 8888;
      if(values.length > 1) {
        port = Integer.parseInt(values[1]);
      }

      String command = input.substring(index); // ==> /board/list


      try (Socket socket = new Socket(host,port);
          PrintWriter out = new PrintWriter(socket.getOutputStream());
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream())); ){

        out.println(command);
        out.flush();

        if (command.equals("/stop")) {
          System.out.println("서버를 종료합니다");
          break;
        } 

        while(true) {
          String response = in.readLine();
          if(response.equalsIgnoreCase("!end!")) {
            break;
          }
          else if (response.equals("!{}!")) {
            String value = keyboard.nextLine();
            out.println(value);
            out.flush();
          } else {
            System.out.println(response);
          }
        } // while

      } catch (Exception e) {
        System.out.println("서버에 요청 중 오류 발생");
        e.printStackTrace();
      }// try(Socket)

    } // while

    keyboard.close();

  } // service()


  @SuppressWarnings("unchecked")
  private void printCommandHistory() {
    Stack<String> temp = (Stack<String>) commandHistory.clone();

    while (temp.size() > 0) {
      System.out.println(temp.pop());
    }
  } // printCommandHistory()


  @SuppressWarnings("unchecked")
  private void printCommandHistory2() {
    Queue<String> temp = (Queue<String>) ((LinkedList<String>) commandHistory2).clone();

    while (temp.size() > 0) {
      System.out.println(temp.poll());
    }
  } // printCommandHistory2()


  private String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  } // prompt()


  public static void main(String[] args) throws Exception {
    ClientApp app = new ClientApp();

    app.service();
  } // main()

} // end of class
