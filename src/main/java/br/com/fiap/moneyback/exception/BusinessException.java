package br.com.fiap.moneyback.exception;
/**
 *
 * <P><B>Description :</B><BR>
 * Exceções reservada para tratamento de negócio.
 * </P>
 * <P>
 * <B>
 * Issues : <BR>
 * None
 * </B>
 *
 */
public class BusinessException extends SystemException{

	public static final long serialVersionUID = 6766489044452746072L;

	public BusinessException(String message, String ...args) {
		super(message, args);
	}

}
