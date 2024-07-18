package guiprogramming.bookshop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookShopForm {

	private JFrame frame;
	private JTextField textAuthor;
	private JTextField textBookName;
	private JTextField textEdition;
	private JTextField textPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookShopForm window = new BookShopForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	
	private BookDao daoBook;
	private JTable table;
	private JTextField textsearchid;
	
	public BookShopForm() {
		
		daoBook = new BookDao();
		initialize();
		loadTable();
	}
	
	public void clearForm() {
		
		textAuthor.setText("");
		textBookName.setText("");
		textEdition.setText("");
		textPrice.setText("");
		textsearchid.setText("");
		
	}
	
	
	
	public void loadTable() {
		
		ResultSet rs = daoBook.loadTableData();
		
		table.setModel(DbUtils.resultSetToTableModel(rs));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1036, 798);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRegistration = new JLabel("Book Shop Management ");
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblRegistration.setBounds(254, 0, 502, 49);
		frame.getContentPane().add(lblRegistration);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Book Registration Form", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 60, 401, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAuthor = new JLabel("Author Name :");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAuthor.setBounds(23, 31, 130, 21);
		panel.add(lblAuthor);
		
		textAuthor = new JTextField();
		textAuthor.setBounds(159, 31, 231, 25);
		panel.add(textAuthor);
		textAuthor.setColumns(10);
		
		JLabel lblBook = new JLabel("Book Name :");
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBook.setBounds(23, 77, 130, 21);
		panel.add(lblBook);
		
		textBookName = new JTextField();
		textBookName.setColumns(10);
		textBookName.setBounds(159, 81, 231, 25);
		panel.add(textBookName);
		
		JLabel lblEdition = new JLabel("Edition :");
		lblEdition.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEdition.setBounds(23, 126, 105, 21);
		panel.add(lblEdition);
		
		textEdition = new JTextField();
		textEdition.setColumns(10);
		textEdition.setBounds(159, 130, 231, 25);
		panel.add(textEdition);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrice.setBounds(23, 182, 105, 21);
		panel.add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(159, 184, 231, 25);
		panel.add(textPrice);
		
		JButton btnRegister = new JButton("Register ");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String author = textAuthor.getText();
				String book = textBookName.getText();
				String edition = textEdition.getText();
				String price = textPrice.getText();
				
				Book bookobject	= new Book(author,book,edition,price);
				daoBook.insertBook(bookobject);
				
				clearForm();
				loadTable();
				
				
			}
		});
		btnRegister.setBounds(159, 220, 105, 36);
		panel.add(btnRegister);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clearForm();
			}
		});
		btnReset.setBounds(285, 220, 105, 36);
		panel.add(btnReset);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(423, 60, 587, 257);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			TableModel model = table.getModel();
			int selectedRow = table.getSelectedRow();
			
			String id = model.getValueAt(selectedRow,0).toString();
			String aName = model.getValueAt(selectedRow,1).toString();
			String bName = model.getValueAt(selectedRow,2).toString();
			String edition = model.getValueAt(selectedRow,3).toString();
			String price = model.getValueAt(selectedRow,4).toString();
			
			textsearchid.setText(id);
			textAuthor.setText(aName);
			textBookName.setText(bName);
			textEdition.setText(edition);
			textPrice.setText(price);
			
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(423, 328, 587, 117);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bookid = textsearchid.getText();
				String author = textAuthor.getText();
				String book = textBookName.getText();
				String edition = textEdition.getText();
				String price = textPrice.getText();
				
				int id = Integer.parseInt(bookid);
				
				Book bookobject	= new Book(id,author,book,edition,price);
				daoBook.updateBook(bookobject);
				
				clearForm();
				loadTable();
				
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBounds(22, 11, 227, 95);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String bookid = textsearchid.getText();
				String author = textAuthor.getText();
				String book = textBookName.getText();
				String edition = textEdition.getText();
				String price = textPrice.getText();
				
				try {
				    int id = Integer.parseInt(bookid);
				    Book bookObject = new Book(id,author,book,edition,price);
				    daoBook.deleteBook(bookObject);
				    clearForm();
				    loadTable();
				} catch (NumberFormatException ex) {
				    JOptionPane.showMessageDialog(null, "Invalid Book ID. Please enter a numeric value.");
				}

				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(331, 11, 227, 95);
		panel_1.add(btnDelete);
		
		JPanel searchpanel = new JPanel();
		searchpanel.setBorder(new TitledBorder(null, "SEARCH BOOK AREA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		searchpanel.setBounds(30, 333, 383, 293);
		frame.getContentPane().add(searchpanel);
		searchpanel.setLayout(null);
		
		JLabel lblSearchid = new JLabel("Search by ID");
		lblSearchid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchid.setBounds(10, 20, 177, 29);
		searchpanel.add(lblSearchid);
		
		textsearchid = new JTextField();
		textsearchid.setBounds(146, 21, 227, 34);
		searchpanel.add(textsearchid);
		textsearchid.setColumns(10);
	}

	protected void deleteBook(int bookId) {
		// TODO Auto-generated method stub
		
	}
}
