package vietnqv.dto.model;

import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the tblCart database table.
 * 
 */
public class Cart_DTO implements Serializable {
	private static final long serialVersionUID = 1L;

	public int idCart;

	public String noteCart;

	public Status_DTO status_DTO;

	public User_DTO user_DTO;
	
	public List<CartDetail_DTO> cartDetails_DTO;

	public Cart_DTO() {
	}

	public Cart_DTO(int idCart, String noteCart, Status_DTO status_DTO, User_DTO user_DTO,
			List<CartDetail_DTO> cartDetails_DTO) {
		
		this.idCart = idCart;
		this.noteCart = noteCart;
		this.status_DTO = status_DTO;
		this.user_DTO = user_DTO;
		this.cartDetails_DTO = cartDetails_DTO;
	}

	
	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public String getNoteCart() {
		return noteCart;
	}

	public void setNoteCart(String noteCart) {
		this.noteCart = noteCart;
	}

	public Status_DTO getStatus_DTO() {
		return status_DTO;
	}

	public void setStatus_DTO(Status_DTO status_DTO) {
		this.status_DTO = status_DTO;
	}

	public User_DTO getUser_DTO() {
		return user_DTO;
	}

	public void setUser_DTO(User_DTO user_DTO) {
		this.user_DTO = user_DTO;
	}

	public List<CartDetail_DTO> getCartDetails_DTO() {
		return cartDetails_DTO;
	}

	public void setCartDetails_DTO(List<CartDetail_DTO> cartDetails_DTO) {
		this.cartDetails_DTO = cartDetails_DTO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Cart_DTO [idCart=" + idCart + ", noteCart=" + noteCart + ", status_DTO=" + status_DTO + ", user_DTO="
				+ user_DTO + ", cartDetails_DTO=" + cartDetails_DTO + "]";
	}
	

}