package huawei;

import huawei.exam.ExamCmd;
import com.huawei.exam.Command;
import com.huawei.exam.ExamSocketServer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 主执行类
 *
 * 考生不得修改，亦无须关注
 */
public class TetrisManiaMain {
    public static void main(String[] args) {
        /**
         * 启动Socket服务侦听5555端口，从Socket获取命令，会丢给Command类的command函数执行
         * Command类的command函数已经实现了从Socket接收到字符串后的解析与分发
         * 考生只需要实现TetrisManiaImpl类的各命令接口即可。
         

        Command cmd = new ExamCmd(new TetrisManiaImpl());
        ExamSocketServer ess = new ExamSocketServer(cmd);
        ess.start();*/
    	Scanner scanner=new Scanner(System.in);
    	TetrisManiaImpl test_map=new TetrisManiaImpl();
    	String order="start";
    	while(order.matches("ends")==false){
    		order=scanner.nextLine();
    		String[] parts=order.split(" ");   		
    		if(parts[0].matches("c")){
    			int num_create=parts.length-1;
    			int[] num_list=new int[num_create];
    			for(int i=0;i<num_create;i++){
    				num_list[i]=Integer.valueOf(parts[i+1]);
    				System.out.print(num_list[i]);
    			}
    			test_map.create(num_list);
    		}else if(parts[0].matches("qq")){
    			int t;
    			t=Integer.valueOf(parts[1]);
    			test_map.queryQueue(t);
    		}else if(parts[0].matches("qp")){
    			int t;
    			t=Integer.valueOf(parts[1]);
    			test_map.queryPanel(t);
    		}else if(parts[0].matches("ml")){
    			int d;
    			d=Integer.valueOf(parts[1]);
    			test_map.moveLeft(d);
    		}else if(parts[0].matches("mr")){
    			int d;
    			d=Integer.valueOf(parts[1]);
    			test_map.moveRight(d);
    		}else if(parts[0].matches("md")){
    			int d;
    			d=Integer.valueOf(parts[1]);
    			test_map.moveDown(d);
    		}else if(parts[0].matches("rt")){
    			test_map.rotate();
    		}else if(parts[0].matches("r")){
    			test_map.reset();
    		}
    		drawMap(test_map.panel);
    	}
    }
    
    public static void drawMap(MyPanel panel){
    	JFrame jframe=new JFrame();
        GridLayout grid = new GridLayout (12, 8);
        JPanel map_draw = new JPanel ();
        map_draw.setLayout (grid);
        Label[][] label = new Label[12][8];
        for ( int i = 0; i < label.length; i++ )
        {
            for ( int j = 0; j < label[i].length; j++ )
            {
                label[i][j] = new Label ();
                if (( i + j ) % 2 == 0){
                    label[i][j].setBackground (Color.white);
                }else{
                    label[i][j].setBackground (Color.black);
                }
                if(panel.table[i][j]==Element.X){
                	label[i][j].setBackground (Color.yellow);
                }else if(panel.table[i][j]==Element.star){
                	label[i][j].setBackground (Color.cyan);
                }
                map_draw.add (label[i][j]);
            }
        }
        jframe.add (map_draw, BorderLayout.CENTER);
        jframe.setBounds (50, 50, 400,500);
        jframe.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        jframe.setVisible (true);
    }
}
