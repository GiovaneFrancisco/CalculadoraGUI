package br.com.gff.calc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.lang.Math;
import java.text.DecimalFormat;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField txtNum1;
	private JTextField txtNum2;
	private JTextField txtResultado;
	private JTextField txtUltimo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		double ultRes = 0;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Calculadora.class.getResource("/br/com/gff/icons/if_calculator_1055102.png")));
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNum1 = new JTextField();
		txtNum1.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNum1.setBounds(143, 11, 86, 20);
		contentPane.add(txtNum1);
		txtNum1.setColumns(10);

		JButton btnSomar = new JButton("");
		btnSomar.setBackground(SystemColor.menu);
		btnSomar.setToolTipText("Soma os 2 valores\r\n");
		btnSomar.setBounds(23, 100, 50, 50);
		btnSomar.setIcon(new ImageIcon(Calculadora.class.getResource("/br/com/gff/icons/Somar 50pxl.png")));
		btnSomar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				somar();
			}
		});

		txtNum2 = new JTextField();
		txtNum2.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNum2.setBounds(143, 52, 86, 20);
		contentPane.add(txtNum2);
		txtNum2.setColumns(10);

		txtResultado = new JTextField();
		txtResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		txtResultado.setBounds(281, 52, 131, 20);
		txtResultado.setEditable(false);
		contentPane.add(txtResultado);
		txtResultado.setColumns(10);

		txtUltimo = new JTextField();
		txtUltimo.setHorizontalAlignment(SwingConstants.RIGHT);
		txtUltimo.setBounds(281, 125, 131, 20);
		txtUltimo.setEditable(false);
		contentPane.add(txtUltimo);
		txtUltimo.setColumns(10);
		contentPane.add(btnSomar);

		JButton btnSubtrair = new JButton("");
		btnSubtrair.setBackground(SystemColor.menu);
		btnSubtrair.setToolTipText("Subtrai os 2 valores\r\n");
		btnSubtrair.setBounds(83, 100, 50, 50);
		btnSubtrair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				subtrair();
			}
		});
		btnSubtrair.setIcon(new ImageIcon(Calculadora.class.getResource("/br/com/gff/icons/Subtrair 50pxl.png")));
		contentPane.add(btnSubtrair);

		JButton btnMultiplicar = new JButton("");
		btnMultiplicar.setBackground(SystemColor.menu);
		btnMultiplicar.setToolTipText("Multiplica os 2 valores");
		btnMultiplicar.setBounds(23, 161, 50, 50);
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				multiplicar();
			}
		});
		btnMultiplicar.setIcon(new ImageIcon(Calculadora.class.getResource("/br/com/gff/icons/Multiplicar 50pxl.png")));
		contentPane.add(btnMultiplicar);

		JButton btnDividir = new JButton("");
		btnDividir.setBackground(SystemColor.menu);
		btnDividir.setToolTipText("Divide os 2 valores");
		btnDividir.setBounds(83, 161, 50, 50);
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dividir();
			}
		});
		btnDividir.setIcon(new ImageIcon(Calculadora.class.getResource("/br/com/gff/icons/Dividir 50pxl.png")));
		contentPane.add(btnDividir);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(SystemColor.menu);
		btnLimpar.setToolTipText("Limpa todos os campos");
		btnLimpar.setBounds(143, 310, 89, 23);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});

		JButton btnSeno = new JButton("Seno");
		btnSeno.setBackground(SystemColor.menu);
		btnSeno.setBounds(143, 100, 89, 23);
		btnSeno.setToolTipText("Seno do primeiro n\u00FAmero");
		btnSeno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seno();
			}
		});
		contentPane.add(btnSeno);

		JButton btnCosseno = new JButton("Cosseno");
		btnCosseno.setBackground(SystemColor.menu);
		btnCosseno.setBounds(143, 127, 89, 23);
		btnCosseno.setToolTipText("Cosseno do primeiro n\u00FAmero");
		btnCosseno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cosseno();
			}
		});
		contentPane.add(btnCosseno);

		JButton btnTangente = new JButton("Tangente");
		btnTangente.setBackground(SystemColor.menu);
		btnTangente.setBounds(143, 153, 89, 23);
		btnTangente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tangente();
			}
		});
		btnTangente.setToolTipText("Tangente do primeiro n\u00FAmero");
		contentPane.add(btnTangente);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSalvar.setForeground(SystemColor.desktop);
		btnSalvar.setBackground(SystemColor.menu);
		btnSalvar.setToolTipText("Salva o \u00FAltimo valor");
		btnSalvar.setBounds(143, 283, 89, 23);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		contentPane.add(btnSalvar);
		contentPane.add(btnLimpar);

		JButton btnQuadrado = new JButton("");
		btnQuadrado.setBackground(SystemColor.menu);
		btnQuadrado.setBounds(23, 222, 50, 50);
		btnQuadrado.setToolTipText("Eleva o primeiro valor ao quadrado");
		btnQuadrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quadrado();
			}
		});
		btnQuadrado.setIcon(new ImageIcon(Calculadora.class.getResource("/br/com/gff/icons/if_square_1772624.png")));
		contentPane.add(btnQuadrado);

		JButton btnElevado = new JButton("");
		btnElevado.setBackground(SystemColor.menu);
		btnElevado.setBounds(83, 222, 50, 50);
		btnElevado.setToolTipText("Usa o segundo valor como expoente");
		btnElevado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				elevado();
			}
		});
		btnElevado.setIcon(new ImageIcon(Calculadora.class.getResource("/br/com/gff/icons/Elevado 50pxl.png")));
		contentPane.add(btnElevado);

		JButton btnPi = new JButton("");
		btnPi.setBackground(SystemColor.menu);
		btnPi.setBounds(83, 283, 50, 50);
		btnPi.setToolTipText("Primeiros 16 digitos de PI");
		btnPi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pi();
			}
		});

		JButton btnRaiz = new JButton("");
		btnRaiz.setBackground(SystemColor.menu);
		btnRaiz.setBounds(23, 283, 50, 50);
		btnRaiz.setToolTipText("Raiz quadrada do primeiro valor");
		btnRaiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				raiz();
			}
		});

		JButton btnFatorial = new JButton("");
		btnFatorial.setBackground(SystemColor.menu);
		btnFatorial.setToolTipText("Fatorial do primeiro n\u00FAmero");
		btnFatorial.setBounds(143, 222, 50, 50);
		btnFatorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fatorial();
			}
		});
		btnFatorial.setIcon(new ImageIcon(Calculadora.class.getResource("/br/com/gff/icons/if_factorial_1772627.png")));
		contentPane.add(btnFatorial);
		btnRaiz.setIcon(new ImageIcon(Calculadora.class.getResource("/br/com/gff/icons/if_square_root_1772628.png")));
		contentPane.add(btnRaiz);
		btnPi.setIcon(new ImageIcon(Calculadora.class.getResource("/br/com/gff/icons/Pi 50pxl.png")));
		contentPane.add(btnPi);

		JLabel lblPrimeiroNumero = new JLabel("Primeiro n\u00FAmero:");
		lblPrimeiroNumero.setBounds(23, 14, 110, 14);
		contentPane.add(lblPrimeiroNumero);

		JLabel lblSegundoNmero = new JLabel("Segundo n\u00FAmero:");
		lblSegundoNmero.setBounds(23, 55, 123, 14);
		contentPane.add(lblSegundoNmero);

		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(281, 27, 131, 14);
		contentPane.add(lblResultado);

		JLabel lblUltimo = new JLabel("\u00DAltimo resultado:");
		lblUltimo.setBounds(281, 100, 131, 14);
		contentPane.add(lblUltimo);

		JList list = new JList();
		list.setBackground(SystemColor.menu);
		list.setBounds(281, 161, 131, 110);
		contentPane.add(list);
	}

	public void salvar() {
		double result;
		String salvar;
		result = Double.parseDouble(txtResultado.getText());
		salvar = Double.toString(result);
		txtUltimo.setText(salvar);
	}

	public void somar() {
		float num1, num2, resultado;
		String result;
		num1 = Float.parseFloat(txtNum1.getText());
		num2 = Float.parseFloat(txtNum2.getText());
		resultado = num1 + num2;
		result = Float.toString(resultado);
		txtResultado.setText(result);
	}

	public void subtrair() {
		float num1, num2, resultado;
		String result;
		num1 = Float.parseFloat(txtNum1.getText());
		num2 = Float.parseFloat(txtNum2.getText());
		resultado = num1 - num2;
		result = Float.toString(resultado);
		txtResultado.setText(result);
	}

	public void multiplicar() {
		float num1, num2, resultado;
		String result;
		num1 = Float.parseFloat(txtNum1.getText());
		num2 = Float.parseFloat(txtNum2.getText());
		resultado = num1 * num2;
		result = Float.toString(resultado);
		txtResultado.setText(result);
	}

	public void dividir() {
		float num1, num2, resultado;
		String result;
		num1 = Float.parseFloat(txtNum1.getText());
		num2 = Float.parseFloat(txtNum2.getText());
		resultado = num1 / num2;
		result = Float.toString(resultado);
		if (num2 == 0) {
			txtResultado.setText("Não se dividde por 0");
		} else {
			txtResultado.setText(result);
		}
	}

	public void cosseno() {
		DecimalFormat formatador = new DecimalFormat("0.00");
		Double num1, num2, resultado, format;
		String result, nume1, nume2;
		nume1 = txtNum1.getText();
		num1 = Double.parseDouble(nume1);
		resultado = Math.cos(num1);
		formatador.format(resultado);
		result = Double.toString(resultado);
		txtResultado.setText(result);
	}

	public void seno() {
		DecimalFormat formatador = new DecimalFormat("#0.00");
		Double num1, num2, resultado, format;
		String result, nume1, nume2;
		nume1 = txtNum1.getText();
		num1 = Double.parseDouble(nume1);
		resultado = Math.sin(num1);
		result = Double.toString(resultado);
		txtResultado.setText(result);
	}

	public void tangente() {
		DecimalFormat formatador = new DecimalFormat("#0.00");
		Double num1, num2, resultado, format;
		String result, nume1, nume2;
		nume1 = txtNum1.getText();
		num1 = Double.parseDouble(nume1);
		resultado = Math.tan(num1);
		result = Double.toString(resultado);
		txtResultado.setText(result);
	}

	public void quadrado() {
		Double num1, quadrado;
		String result;
		num1 = Double.parseDouble(txtNum1.getText());
		quadrado = Math.pow(num1, 2);
		result = Double.toString(quadrado);
		txtResultado.setText(result);
	}

	public void elevado() {
		Double num1, num2, elev;
		String result;
		num1 = Double.parseDouble(txtNum1.getText());
		num2 = Double.parseDouble(txtNum2.getText());
		elev = Math.pow(num1, num2);
		result = Double.toString(elev);
		txtResultado.setText(result);
	}

	public void raiz() {
		Double num1, raiz;
		String result;
		num1 = Double.parseDouble(txtNum1.getText());
		raiz = Math.sqrt(num1);
		result = Double.toString(raiz);
		txtResultado.setText(result);
	}

	public void pi() {
		Double pi;
		String result;
		pi = Math.PI;
		result = Double.toString(pi);
		txtResultado.setText(result);
	}

	public void fatorial() {
		Double num, fat = 1.0;
		String result;
		num = Double.parseDouble(txtNum1.getText());
		if (num > 18) {
			txtResultado.setText("Valor máximo excedido");
		} else {
			for (Double i = num; i > 0; i--) {
				fat = fat * i;
				result = Double.toString(fat);
				txtResultado.setText(result);
			}
		}
	}

	public void limpar() {
		txtNum1.setText(null);
		txtNum2.setText(null);
		txtResultado.setText(null);
		txtUltimo.setText(null);
	}
}
