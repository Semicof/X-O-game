import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class XOgame implements ActionListener {
    Random random=new Random();
    JFrame frame=new JFrame();
    JPanel tPanel=new JPanel();
    JPanel bPanel=new JPanel();
    JLabel textField=new JLabel();
    JButton[] buttons=new JButton[9];
    boolean p1Turn;
    XOgame()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.getContentPane().setBackground(Color.lightGray);
        frame.setLayout(new BorderLayout());

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free",Font.BOLD,75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("X-O Game");
        textField.setOpaque(true);

        tPanel.setLayout(new BorderLayout());
        tPanel.setBounds(0,0,600,100);

        bPanel.setLayout(new GridLayout(3,3));
        bPanel.setBackground(new Color(150,150,150));

        for(int i=0;i<9;i++)
        {
            buttons[i]=new JButton();
            bPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        tPanel.add(textField);
        frame.add(tPanel,BorderLayout.NORTH);
        frame.add(bPanel);
        frame.setVisible(true);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++)
        {
            if(e.getSource()==buttons[i])
            {
                if(p1Turn)
                {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        textField.setText("O turn");
                        p1Turn=false;
                        check();
                    }
                }
                else {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(Color.GREEN);
                        buttons[i].setText("O");
                        textField.setText("X turn");
                        p1Turn=true;
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(random.nextInt(2)==0)
        {
            p1Turn=true;
            textField.setText("X turn");
        }
        else {
            p1Turn=false;
            textField.setText("O turn");
        }
        return;
    }

    public void check()
    {
        //X's Win Condition
        if(buttons[0].getText()=="X"&&buttons[1].getText()=="X"&&buttons[2].getText()=="X")
        {
            xWin(0,1,2);
        }

        if(buttons[3].getText()=="X"&&buttons[4].getText()=="X"&&buttons[5].getText()=="X")
        {
            xWin(3,4,5);
        }

        if(buttons[6].getText()=="X"&&buttons[7].getText()=="X"&&buttons[8].getText()=="X")
        {
            xWin(6,7,8);
        }

        if(buttons[0].getText()=="X"&&buttons[3].getText()=="X"&&buttons[6].getText()=="X")
        {
            xWin(0,3,6);
        }

        if(buttons[1].getText()=="X"&&buttons[4].getText()=="X"&&buttons[7].getText()=="X")
        {
            xWin(1,4,7);
        }

        if(buttons[2].getText()=="X"&&buttons[5].getText()=="X"&&buttons[8].getText()=="X")
        {
            xWin(2,5,8);
        }

        if(buttons[0].getText()=="X"&&buttons[4].getText()=="X"&&buttons[8].getText()=="X")
        {
            xWin(0,4,8);
        }

        if(buttons[2].getText()=="X"&&buttons[4].getText()=="X"&&buttons[6].getText()=="X")
        {
            xWin(2,4,6);
        }

        //O's Win Condition

        if(buttons[0].getText()=="O"&&buttons[1].getText()=="O"&&buttons[2].getText()=="O")
        {
            oWin(0,1,2);
        }

        if(buttons[3].getText()=="O"&&buttons[4].getText()=="O"&&buttons[5].getText()=="O")
        {
            oWin(3,4,5);
        }

        if(buttons[6].getText()=="O"&&buttons[7].getText()=="O"&&buttons[8].getText()=="O")
        {
            oWin(6,7,8);
        }

        if(buttons[0].getText()=="O"&&buttons[3].getText()=="O"&&buttons[6].getText()=="O")
        {
            oWin(0,3,6);
        }

        if(buttons[1].getText()=="O"&&buttons[4].getText()=="O"&&buttons[7].getText()=="O")
        {
            oWin(1,4,7);
        }

        if(buttons[2].getText()=="O"&&buttons[5].getText()=="O"&&buttons[8].getText()=="O")
        {
            oWin(2,5,8);
        }

        if(buttons[0].getText()=="O"&&buttons[4].getText()=="O"&&buttons[8].getText()=="O")
        {
            oWin(0,4,8);
        }

        if(buttons[2].getText()=="O"&&buttons[4].getText()=="O"&&buttons[6].getText()=="O")
        {
            oWin(2,4,6);
        }
    }

    public void xWin(int a,int b,int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
        textField.setText("X Wins");
    }
    public void oWin(int a,int b,int c)
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
        textField.setText("O Wins");
    }
}
