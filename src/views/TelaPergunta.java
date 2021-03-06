package views;


import rede.AtorJogador;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaPergunta extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	protected AtorJogador atorJogador;
    protected int resposta;
    
    public TelaPergunta(AtorJogador atorJogador) {
    	setResizable(false);
    	setTitle("Pergunta");
    	this.atorJogador = atorJogador;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonAlternativa1 = new javax.swing.JButton();
        jButtonAlternativa1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ev) {
        		setResposta(1);
        		atorJogador.getTelaPrincipal().habilitaBotaoSortear();
        	}
        });
        jButtonAlternativa2 = new javax.swing.JButton();
        jButtonAlternativa2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ev) {
        		setResposta(2);
        		atorJogador.getTelaPrincipal().habilitaBotaoSortear();
        	}
        });
        jButtonAlternativa3 = new javax.swing.JButton();
        jButtonAlternativa3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setResposta(3);
				atorJogador.getTelaPrincipal().habilitaBotaoSortear();
			}
		});
        jButtonAlternativa4 = new javax.swing.JButton();
        jButtonAlternativa4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setResposta(4);
				atorJogador.getTelaPrincipal().habilitaBotaoSortear();
			}
		});
        jLabelEnunciado = new javax.swing.JLabel();
        jLabelEnunciado.setFont(new Font("Tahoma", Font.BOLD, 15));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAlternativa1.setText("Alternativa1");

        jButtonAlternativa2.setText("Alternativa2");

        jButtonAlternativa3.setText("Alternativa3");

        jButtonAlternativa4.setText("Alternativa4");

        jLabelEnunciado.setText("Enunciado");
        jLabelEnunciado.setHorizontalAlignment(SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(104)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jButtonAlternativa2, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        				.addComponent(jButtonAlternativa3, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        				.addComponent(jButtonAlternativa4, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
        				.addComponent(jButtonAlternativa1, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
        			.addGap(123))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabelEnunciado, GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(36)
        			.addComponent(jLabelEnunciado, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jButtonAlternativa1, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jButtonAlternativa2, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jButtonAlternativa3, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jButtonAlternativa4, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        			.addGap(13))
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private javax.swing.JButton jButtonAlternativa1;
    private javax.swing.JButton jButtonAlternativa2;
    private javax.swing.JButton jButtonAlternativa3;
    private javax.swing.JButton jButtonAlternativa4;
    private javax.swing.JLabel jLabelEnunciado;
    private javax.swing.JPanel jPanel1;
    
    public void exibirTela(String enunciado, String[] alternativas) {
    	jLabelEnunciado.setText(enunciado);
    	jButtonAlternativa1.setText(alternativas[0]);
    	jButtonAlternativa2.setText(alternativas[1]);
    	jButtonAlternativa3.setText(alternativas[2]);
    	jButtonAlternativa4.setText(alternativas[3]);
    	setVisible(true);
    }
    
	public void setResposta(int n) {
		this.resposta = n;
		atorJogador.conferirResposta(resposta);
	}

	public void errou() {
		//JOptionPane.showMessageDialog(null, "Reposta errada");
        ImageIcon iconErrou = new ImageIcon(TelaPergunta.class.getResource("errou.gif"));
        JOptionPane.showMessageDialog(
                null,
                "",
                "Voc� errou!", JOptionPane.INFORMATION_MESSAGE,
                iconErrou);
		this.dispose();
	}
	
	public void acertou() {
		//JOptionPane.showMessageDialog(null, "Resposta certa");
        ImageIcon iconAcertou = new ImageIcon(TelaPergunta.class.getResource("acertou.gif"));
        JOptionPane.showMessageDialog(
                null,
                "",
                "Certa resposta!", JOptionPane.INFORMATION_MESSAGE,
                iconAcertou);
		
		this.dispose();
	}
}