package JBproj2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import JBproj2.Collection;

import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.Rectangle;
import java.awt.event.MouseMotionAdapter;
import java.util.Iterator;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JRadioButton;

public class JBproj2Panel extends JPanel{
	private Collection allTheSongs = new Collection();
	private Collection myCollection = new Collection();
	private JPanel controlPanel;
	private JLabel lblNewLabel;
	private JComboBox comboBox_1;
	private JTextField txtNameYourPlaylist;
	private JTextArea PNB;
	private ImageIcon image;
	private JButton btnNewButton;
	private JButton btnAddSongTo;
	private JTextArea textArea;
	private JScrollPane scrollPane_2;
	private JTextArea txtrAddSongs;
	private JButton btnRemoveSongTo;
	private JTextField textField;
	private JLabel lblEnterSongId;

	public JBproj2Panel() {
		// puts all songs from final tracks into allTheSongs collection
		String fullFile = "JBproj2/finalTracks.csv";
		allTheSongs.readFile(fullFile);
		String[] genres = allTheSongs.getGenres();
		System.out.print("("+genres.length+")");
		for (int i = 0; i < genres.length; i++) {
			String s = genres[i];
			System.out.print(s+"/");
		}
		
		// paints image
		image = new ImageIcon (this.getClass().getResource("/JBproj2/download2.jpg"));

		controlPanel = new JPanel();
		controlPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN));
		controlPanel.setBounds(320, 0, 180, 550);
		controlPanel.setPreferredSize (new Dimension(250, 500));
		controlPanel.setBackground (Color.DARK_GRAY);

		setPreferredSize (new Dimension(369, 501));
		setBackground (Color.white);
		setLayout(null);
		add(controlPanel);
		controlPanel.setLayout(null);

		// text field to allow user to name their playlist
		txtNameYourPlaylist = new JTextField();
		txtNameYourPlaylist.setHorizontalAlignment(SwingConstants.CENTER);
		txtNameYourPlaylist.setBackground(Color.LIGHT_GRAY);
		txtNameYourPlaylist.setText("Name your playlist here!");
		txtNameYourPlaylist.setBounds(10, 11, 160, 47);
		controlPanel.add(txtNameYourPlaylist);
		txtNameYourPlaylist.setColumns(10);
		
		// shows all the songs in users playlist
		txtrAddSongs = new JTextArea();
		txtrAddSongs.setBackground(Color.LIGHT_GRAY);
		txtrAddSongs.setText("Add songs!");
		txtrAddSongs.setBounds(10, 70, 160, 394);
		controlPanel.add(txtrAddSongs);
		
		// Radio button that doesnt work
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Playlist Name: ");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
			String playlistName = txtNameYourPlaylist.getText();
				PNB = new JTextArea();
				PNB.setBackground(Color.LIGHT_GRAY);
				PNB.setText(playlistName);
				PNB.setBounds(250,250,150,150);
				controlPanel.add(PNB);
				*/
				image = new ImageIcon (this.getClass().getResource("/JBproj2/download2.jpg"));
				repaint();
			}
		});
		rdbtnNewRadioButton.setBounds(38, 471, 109, 23);
		controlPanel.add(rdbtnNewRadioButton);

		// sets main panels
		setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GREEN, Color.GREEN, Color.GREEN, Color.GREEN));
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(500, 550));

		// combo box displaying genres
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(Color.LIGHT_GRAY);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.setToolTipText(""+comboBox_1.getSelectedItem());
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(allTheSongs.getGenres()));
		comboBox_1.setBounds(35, 253, 248, 33);
		add(comboBox_1);

		// label that prompts user to select a genre
		lblNewLabel = new JLabel("Select a Genre!");
		lblNewLabel.setBounds(35, 223, 126, 33);
		add(lblNewLabel);
		
		// text are for all songs from selected genre with scroll pane
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(35, 331, 248, 100);
		add(scrollPane_2);
		textArea = new JTextArea();
		scrollPane_2.setViewportView(textArea);
		textArea.setBackground(Color.LIGHT_GRAY);
		
		// button that puts all songs from genre into textArea
		btnNewButton = new JButton("Search!");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Collection songs = allTheSongs.findSongByGenre(""+comboBox_1.getSelectedItem());
				String aString = "";
				Iterator<Song> iter = songs.getIterator();
				while (iter.hasNext()) {
					Song s = iter.next();
					aString += s + "\n";
					
				}
				textArea.setText(aString);
			}
		});
		btnNewButton.setBounds(124, 297, 89, 23);
		add(btnNewButton);
		
		// prompts user to enter song ID
		lblEnterSongId = new JLabel("Enter Song ID:");
		lblEnterSongId.setBounds(81, 440, 80, 14);
		add(lblEnterSongId);
		
		// user types ID here
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(163, 440, 86, 14);
		add(textField);
		textField.setColumns(10);
		
		// adds song by ID entered by user to playlist
		btnAddSongTo = new JButton("Add Song to Playlist");
		btnAddSongTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				int id=Integer.parseInt(name);
				Song song = allTheSongs.findSongByID(id);
				myCollection.add(song);
				
				String aString = "";
				Iterator<Song> iter = myCollection.getIterator();
				while (iter.hasNext()) {
					Song s = iter.next();
					aString += s + "\n";
					
				}
				txtrAddSongs.setText(aString);
			}
		});
		btnAddSongTo.setBounds(81, 465, 168, 23);
		add(btnAddSongTo);
}

	// paints the image
	public void paintComponent (Graphics page)
	{
		super.paintComponent (page);
		image.paintIcon (this, page, 25, 25);
	}
}

