package com.xiaojinzi.tally.module.datasource.spi

import com.xiaojinzi.component.anno.ServiceAnno
import com.xiaojinzi.tally.lib.res.model.ai.AiBillAnalyzeResDto
import com.xiaojinzi.tally.lib.res.model.app_update.AppUpdateResDto
import com.xiaojinzi.tally.lib.res.model.network.AppNetworkException
import com.xiaojinzi.tally.lib.res.model.support.AliSTSTokenResDto
import com.xiaojinzi.tally.lib.res.model.tally.BillCycleResDto
import com.xiaojinzi.tally.lib.res.model.tally.BookInviteShareResDto
import com.xiaojinzi.tally.lib.res.model.tally.TallyBookDto
import com.xiaojinzi.tally.lib.res.model.tally.TallyBookMemberResDto
import com.xiaojinzi.tally.lib.res.model.tally.TallyBookNecessaryInfoResDto
import com.xiaojinzi.tally.lib.res.model.tally.TallyInitSyncRes
import com.xiaojinzi.tally.lib.res.model.tally.TallyRemoteAccountReq
import com.xiaojinzi.tally.lib.res.model.tally.TallyRemoteAccountRes
import com.xiaojinzi.tally.lib.res.model.tally.TallyRemoteBillImageReq
import com.xiaojinzi.tally.lib.res.model.tally.TallyRemoteBillImageRes
import com.xiaojinzi.tally.lib.res.model.tally.TallyRemoteBillLabelReq
import com.xiaojinzi.tally.lib.res.model.tally.TallyRemoteBillLabelRes
import com.xiaojinzi.tally.lib.res.model.tally.TallyRemoteBillReq
import com.xiaojinzi.tally.lib.res.model.tally.TallyRemoteBillRes
import com.xiaojinzi.tally.lib.res.model.tally.TallyRemoteBookTypeResDto
import com.xiaojinzi.tally.lib.res.model.tally.TallyRemoteCategoryReq
import com.xiaojinzi.tally.lib.res.model.tally.TallyRemoteCategoryRes
import com.xiaojinzi.tally.lib.res.model.tally.TallyRemoteLabelReq
import com.xiaojinzi.tally.lib.res.model.tally.TallyRemoteLabelRes
import com.xiaojinzi.tally.lib.res.model.user.LoginResDto
import com.xiaojinzi.tally.lib.res.model.user.TokenResDto
import com.xiaojinzi.tally.lib.res.model.user.UserInfoDto
import com.xiaojinzi.tally.lib.res.model.user.UserVipResDto
import com.xiaojinzi.tally.lib.res.model.user.VipItemResDto
import com.xiaojinzi.tally.lib.res.model.user.WxLoginResDto
import com.xiaojinzi.tally.module.base.spi.AppNetworkSpi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@ServiceAnno(AppNetworkSpi::class)
class AppNetworkSpiImpl : AppNetworkSpi {

    private val OPEN_SOURCE_HOT_SUPPORT_EXCEPTION = AppNetworkException(
        code = AppNetworkException.CODE_NOT_SUPPORT,
        message = "开源版本不支持此操作",
    )

    override suspend fun sendCheckCode(
        usage: String,
        phoneNumber: String,
    ) {
    }

    override suspend fun loginByCheckCode(
        phoneNumber: String,
        checkCode: String,
    ): LoginResDto {
        return LoginResDto.createUserInfoForOpenSource()
    }

    override suspend fun loginByBindWx(
        authId: String,
        phoneNumber: String,
        checkCode: String,
    ): LoginResDto {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun loginByWx(wxCode: String): WxLoginResDto {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun logout() {
    }

    override suspend fun logOff() {
    }

    override suspend fun refreshToken(): TokenResDto {
        return TokenResDto.createUserInfoForOpenSource()
    }

    override suspend fun getUserInfo(userId: String): UserInfoDto {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun getUserInfoList(userIdList: List<String>): List<UserInfoDto> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun initSync(): TallyInitSyncRes {
        return withContext(context = Dispatchers.IO) {
            TallyInitSyncRes.createForOpenSource()
        }
    }

    override suspend fun getBookList(): List<TallyBookDto> {
        return listOf(
            TallyBookDto.createForOpenSource(),
        )
    }

    override suspend fun categoryIsEmpty(
        userToken: String?
    ): Boolean {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun getBookTypeList(): List<TallyRemoteBookTypeResDto> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun getBookMemberList(bookId: String): List<TallyBookMemberResDto> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun exitBook(
        bookId: String,
        targetUserId: String,
    ) {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun createBook(
        type: String,
        name: String,
    ): TallyBookNecessaryInfoResDto {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun createBookShareInfo(bookId: String): BookInviteShareResDto {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun acceptBookShare(
        code: String,
        bookId: String
    ): TallyBookNecessaryInfoResDto {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun getAliOssStsToken(): AliSTSTokenResDto {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun getVipItems(): List<VipItemResDto> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun createAlipayVipOrder(itemId: String): String {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun getVipInfo(): UserVipResDto {
        return UserVipResDto.createForOpensource()
    }

    override suspend fun getNewUpdate(): AppUpdateResDto? {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun deleteBillCycleById(
        id: Long,
    ) {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun getBillCycleById(
        id: Long,
    ): BillCycleResDto {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun getBillCycleList(): List<BillCycleResDto> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun setBillCycleState(
        id: Long,
        state: String,
    ): BillCycleResDto {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun runBillCycleOnce(
        id: Long,
    ): BillCycleResDto {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun createOrUpdateBillCycle(
        id: Long?,
        bookId: String,
        cycleType: String,
        loopCount: Int?,
        timeZone: Int,
        dayOfMonth: Int?,
        dayOfWeek: Int?,
        hour: Int,
        billType: String,
        categoryId: String?,
        accountId: String?,
        transferTargetAccountId: String?,
        amount: Long,
        note: String?,
    ): BillCycleResDto {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun aiBillAnalyze(
        spendingCategoryNameList: List<String>,
        incomeCategoryNameList: List<String>,
        content: String,
    ): AiBillAnalyzeResDto {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun getNeedSyncAccountList(
        bookId: String,
        timeModify: Long?,
        pageSize: Int,
    ): List<TallyRemoteAccountRes> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun accountSync(
        timeModify: Long?,
        dataList: List<TallyRemoteAccountReq>,
    ): List<TallyRemoteAccountRes> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun getNeedSyncBillImageList(
        bookId: String,
        timeModify: Long?,
        pageSize: Int,
    ): List<TallyRemoteBillImageRes> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun billImageSync(
        timeModify: Long?,
        dataList: List<TallyRemoteBillImageReq>,
    ): List<TallyRemoteBillImageRes> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun getNeedSyncBillLabelList(
        bookId: String,
        timeModify: Long?,
        pageSize: Int,
    ): List<TallyRemoteBillLabelRes> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun billLabelSync(
        timeModify: Long?,
        dataList: List<TallyRemoteBillLabelReq>,
    ): List<TallyRemoteBillLabelRes> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun getNeedSyncBillList(
        bookId: String,
        timeModify: Long?,
        pageSize: Int,
    ): List<TallyRemoteBillRes> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun billSync(
        timeModify: Long?,
        dataList: List<TallyRemoteBillReq>,
    ): List<TallyRemoteBillRes> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun getNeedSyncCategoryList(
        bookId: String,
        timeModify: Long?,
        pageSize: Int,
    ): List<TallyRemoteCategoryRes> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun categorySync(
        timeModify: Long?,
        dataList: List<TallyRemoteCategoryReq>,
    ): List<TallyRemoteCategoryRes> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun getNeedSyncLabelList(
        bookId: String,
        timeModify: Long?,
        pageSize: Int,
    ): List<TallyRemoteLabelRes> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

    override suspend fun labelSync(
        timeModify: Long?,
        dataList: List<TallyRemoteLabelReq>,
    ): List<TallyRemoteLabelRes> {
        throw OPEN_SOURCE_HOT_SUPPORT_EXCEPTION
    }

}