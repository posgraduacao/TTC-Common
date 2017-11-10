package br.com.felipe.tcc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.felipe.tcc.utils.DateSerializer;

@Entity
@Table(name = "chamado")
public class Chamado extends Default {

	private static final long serialVersionUID = 1L;

	@Column(name = "solicitacao")
	private String solicitacao;
	@Column(name = "observacao")
	private String observacao;
	@Column(name = "status")
	private String status;
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "data_abertura")
	private Date dataAbertura;
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "data_fechamento")
	private Date dataFechamento;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	@JsonBackReference
	@OneToMany(mappedBy = "chamado", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AcaoChamado> acoesChamado = new ArrayList<>();

	public String getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(String solicitacao) {
		this.solicitacao = solicitacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura() {
		this.dataAbertura = new Date();
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento() {
		this.dataFechamento = new Date();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<AcaoChamado> getAcoesChamado() {
		return acoesChamado;
	}

	public void setAcoesChamado(List<AcaoChamado> acoesChamado) {
		this.acoesChamado = acoesChamado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((acoesChamado == null) ? 0 : acoesChamado.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((dataAbertura == null) ? 0 : dataAbertura.hashCode());
		result = prime * result + ((dataFechamento == null) ? 0 : dataFechamento.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + ((solicitacao == null) ? 0 : solicitacao.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		if (acoesChamado == null) {
			if (other.acoesChamado != null)
				return false;
		} else if (!acoesChamado.equals(other.acoesChamado))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataAbertura == null) {
			if (other.dataAbertura != null)
				return false;
		} else if (!dataAbertura.equals(other.dataAbertura))
			return false;
		if (dataFechamento == null) {
			if (other.dataFechamento != null)
				return false;
		} else if (!dataFechamento.equals(other.dataFechamento))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (solicitacao == null) {
			if (other.solicitacao != null)
				return false;
		} else if (!solicitacao.equals(other.solicitacao))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}
