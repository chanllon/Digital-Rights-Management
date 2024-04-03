package moe._47saikyo.service.impl

import moe._47saikyo.BlockChain
import moe._47saikyo.CurrencyConverter
import moe._47saikyo.exception.BlockChainNotConnectedException
import moe._47saikyo.service.AccountService
import moe._47saikyo.utils.CryptoUtils
import org.web3j.crypto.Keys
import org.web3j.crypto.Wallet
import org.web3j.crypto.WalletFile
import org.web3j.crypto.WalletUtils
import org.web3j.protocol.core.DefaultBlockParameterName
import org.web3j.tx.RawTransactionManager
import org.web3j.tx.TransactionManager
import org.web3j.tx.Transfer
import org.web3j.utils.Convert
import java.math.BigDecimal

/**
 * 以太坊账户Service类
 *
 * @author 刘一邦
 */
class AccountServiceImpl : AccountService {
    override fun newAccount(password: String): WalletFile =
        Wallet.createStandard(password, Keys.createEcKeyPair())

    @Deprecated("Use newAccount instead")
    override fun newAccountByPersonal(password: String): String =
        if (!BlockChain.connected)
            throw BlockChainNotConnectedException("BlockChain not connected")
        else BlockChain.web3jInstance!!.personalNewAccount(password).send().result

    override fun getBalance(addr: String): BigDecimal =
        if (!BlockChain.connected)
            throw BlockChainNotConnectedException("BlockChain not connected")
        else {
            CurrencyConverter.weiToEther(
                BlockChain.web3jInstance!!.ethGetBalance(addr, DefaultBlockParameterName.LATEST).send().balance
            )
        }

    override fun chargeFromBank(addr: String, value: String): Boolean {
        try {
            Transfer(BlockChain.web3jInstance, BlockChain.bankTxManager)
                .sendFunds(addr, BigDecimal(value), Convert.Unit.ETHER).send()
            return true
        } catch (e: Exception) {
            return false
        }
    }

    override fun getTxManager(pwd: String, keyFileContent: String): TransactionManager {
        val credentials = WalletUtils.loadJsonCredentials(pwd, keyFileContent)
        return RawTransactionManager(
            BlockChain.web3jInstance, credentials, BlockChain.chainId
        )
    }
}