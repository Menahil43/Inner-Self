package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EQTest extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][5]; // Store personality mappings for each option
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, back; // Added back button

    public static int count = 0;
    public static int score = 0;

    // Personality trait scores
    int[] personalityScores = new int[5]; // 5 traits (e.g., empathy, adaptability, resilience, communication, self-awareness)
    String name;

    EQTest(String name) {
        this.name = name;
        setBounds(100, 50, 1150, 700);
        getContentPane().setBackground(new Color(0x4F0D03));
        setUndecorated(true);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eq-01.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1150, 300);
        add(image);

        Color textColor = new Color(0xEFA43C);

        qno = new JLabel();
        qno.setBounds(50, 350, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        qno.setForeground(textColor);
        add(qno);

        question = new JLabel();
        question.setBounds(100, 350, 1000, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        question.setForeground(textColor);
        add(question);

        // Define questions, answers, and trait mappings
        questions[0][0] = "How do you build and maintain trust in your relationships?";
        questions[0][1] = "By being honest and transparent in my communication"; // Communication
        questions[0][2] = "By consistently following through on promises and commitments"; // Responsibility
        questions[0][3] = "By showing empathy and understanding when the other person is in need"; // Empathy
        questions[0][4] = "By respecting boundaries and valuing the other person's perspective"; // Respect

        questions[1][0] = "What keeps you motivated during challenging times?";
        questions[1][1] = "External rewards";
        questions[1][2] = "Personal growth";
        questions[1][3] = "Fear of failure";
        questions[1][4] = "Support from others";

        questions[2][0] = "When someone is upset, do you:?";
        questions[2][1] = "Offer advice";
        questions[2][2] = "Listen without judgment";
        questions[2][3] = "Avoid the conversation";
        questions[2][4] = "Try to cheer them up or distract them";

        questions[3][0] = "What strategies do you use to control impulsive decisions?";
        questions[3][1] = "Pause and take a deep breath.";
        questions[3][2] = "Consider the consequences.";
        questions[3][3] = "Seek input from others.";
        questions[3][4] = "Focus on long-term goals.";

        questions[4][0] = "How well do you adapt to unexpected changes in your plans?";
        questions[4][1] = "I stay calm and quickly adjust to the new situation.";
        questions[4][2] = "I feel frustrated at first but eventually find a solution.";
        questions[4][3] = "I struggle to adapt and often resist the change.";
        questions[4][4] = "I try to stick to the original plan as much as possible.";

        questions[5][0] = "Can you recognize your emotions as they arise, and do you understand what triggers them?";
        questions[5][1] = "Yes, I can quickly identify and understand my emotions.";
        questions[5][2] = "I recognize them but need time to understand the triggers.";
        questions[5][3] = "I sometimes struggle to identify my emotions.";
        questions[5][4] = "I rarely notice my emotions until they affect my behavior.";

        questions[6][0] = "How do you feel when you’re not performing as well as you expected?";
        questions[6][1] = "Motivated to try harder";
        questions[6][2] = "Frustrated but willing to improve";
        questions[6][3] = "Disappointed and discouraged";
        questions[6][4] = "Indifferent";

        questions[7][0] = "How do you typically react when you’re criticized?";
        questions[7][1] = "I listen and try to improve";
        questions[7][2] = "I get defensive but try to understand";
        questions[7][3] = "I ignore the criticism";
        questions[7][4] = "I feel hurt and withdraw";

        questions[8][0] = "How do you handle disagreements in a group setting?";
        questions[8][1] = "I listen to all sides and help find a compromise";
        questions[8][2] = "I stand my ground and try to convince others";
        questions[8][3] = "I avoid confrontation and let others decide";
        questions[8][4] = "I stay quiet and wait for the conflict to resolve itself";

        questions[9][0] = "How often do you take a break or step back before reacting to a stressful situation?";
        questions[9][1] = "Always";
        questions[9][2] = "Sometimes";
        questions[9][3] = "Rarely";
        questions[9][4] = "Never";

        // Assign personality mappings for each option
        answers[0][1] = "Communication";
        answers[0][2] = "Responsibility";
        answers[0][3] = "Empathy";
        answers[0][4] = "Respect";

        answers[1][1] = "Resilience";
        answers[1][2] = "Self-Awareness";
        answers[1][3] = "Adaptability";
        answers[1][4] = "Empathy";

        answers[2][1] = "Communication";
        answers[2][2] = "Empathy";
        answers[2][3] = "Resilience";
        answers[2][4] = "Adaptability";

        answers[3][1] = "Resilience";
        answers[3][2] = "Self-Awareness";
        answers[3][3] = "Communication";
        answers[3][4] = "Adaptability";

        answers[4][1] = "Adaptability";
        answers[4][2] = "Resilience";
        answers[4][3] = "Self-Awareness";
        answers[4][4] = "Communication";

        answers[5][1] = "Self-Awareness";
        answers[5][2] = "Self-Awareness";
        answers[5][3] = "Empathy";
        answers[5][4] = "Resilience";

        answers[6][1] = "Resilience";
        answers[6][2] = "Resilience";
        answers[6][3] = "Self-Awareness";
        answers[6][4] = "Adaptability";

        answers[7][1] = "Self-Awareness";
        answers[7][2] = "Resilience";
        answers[7][3] = "Adaptability";
        answers[7][4] = "Empathy";

        answers[8][1] = "Communication";
        answers[8][2] = "Resilience";
        answers[8][3] = "Empathy";
        answers[8][4] = "Adaptability";

        answers[9][1] = "Resilience";
        answers[9][2] = "Self-Awareness";
        answers[9][3] = "Adaptability";
        answers[9][4] = "Resilience";



        opt1 = new JRadioButton();
        opt1.setBounds(120, 400, 800, 25);
        opt1.setBackground(new Color(0x4F0D03));
        opt1.setForeground(textColor);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt1.setBorder(null);
        opt1.setContentAreaFilled(false);
        opt1.setOpaque(true);
        opt1.setFocusPainted(false);

        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(120, 430, 800, 25);
        opt2.setBackground(new Color(0x4F0D03));
        opt2.setForeground(textColor);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt2.setBorder(null);
        opt2.setContentAreaFilled(false);
        opt2.setOpaque(true);
        opt2.setFocusPainted(false);

        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(120, 460, 800, 25);
        opt3.setBackground(new Color(0x4F0D03));
        opt3.setForeground(textColor);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt3.setBorder(null);
        opt3.setContentAreaFilled(false);
        opt3.setOpaque(true);
        opt3.setFocusPainted(false);

        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(120, 490, 800, 25);
        opt4.setBackground(new Color(0x4F0D03));
        opt4.setForeground(textColor);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        opt4.setBorder(null);
        opt4.setContentAreaFilled(false);
        opt4.setOpaque(true);
        opt4.setFocusPainted(false);

        add(opt4);

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        back = new JButton("Back");
        back.setBounds(450, 600, 150, 30); // Positioned before Next
        back.setFont(new Font("Tahoma", Font.PLAIN, 18));
        back.setBackground(new Color(0xFFA500));
        back.setForeground(new Color(0x4F0D03));
        back.addActionListener(this);
        back.setEnabled(false); // Initially disabled
        back.setFocusPainted(false);
        back.setBorderPainted(false);
        back.setBorder(null);
        back.setContentAreaFilled(false);
        back.setOpaque(true);
        add(back);

        next = new JButton("Next");
        next.setBounds(650, 600, 150, 30);
        next.setFont(new Font("Tahoma", Font.PLAIN, 18));
        next.setBackground(new Color(22, 99, 54));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setFocusPainted(false);
        next.setBorderPainted(false);
        next.setBorder(null);
        next.setContentAreaFilled(false);
        next.setOpaque(true);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(850, 600, 150, 30);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        submit.setBackground(new Color(0xFFA500));
        submit.setForeground(new Color(0x4F0D03));
        submit.addActionListener(this);
        submit.setEnabled(false);
        submit.setFocusPainted(false);
        submit.setBorderPainted(false);
        submit.setBorder(null);
        submit.setContentAreaFilled(false);
        submit.setOpaque(true);
        add(submit);

        start(count);
        setUndecorated(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            if (groupoptions.getSelection() != null) {
                String selectedTrait = groupoptions.getSelection().getActionCommand();
                updatePersonalityScore(selectedTrait);
            }

            count++;
            start(count);

            // Enable Back button after the first question
            back.setEnabled(count > 0);

            if (count == 9) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
        } else if (ae.getSource() == back) {
            count--;
            start(count);

            // Disable Back button if we're at the first question
            back.setEnabled(count > 0);

            // Enable Next button
            next.setEnabled(true);
            submit.setEnabled(false);
        } else if (ae.getSource() == submit) {
            if (groupoptions.getSelection() != null) {
                String selectedTrait = groupoptions.getSelection().getActionCommand();
                updatePersonalityScore(selectedTrait);
            }

            setVisible(false);
            new Score(name, score, personalityScores); // Pass trait scores
        }
    }

    private void updatePersonalityScore(String trait) {
        switch (trait) {
            case "Communication":
                personalityScores[0]++;
                break;
            case "Empathy":
                personalityScores[1]++;
                break;
            case "Adaptability":
                personalityScores[2]++;
                break;
            case "Resilience":
                personalityScores[3]++;
                break;
            case "Self-Awareness":
                personalityScores[4]++;
                break;
        }
    }

    public void start(int count) {
        qno.setText((count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(answers[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(answers[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(answers[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(answers[count][4]);
        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new EQTest("User");
    }
}
