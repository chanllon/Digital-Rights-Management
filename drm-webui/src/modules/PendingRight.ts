import Constant from "~/constant/Constant.ts";

class PendingRight {
    id: number = Constant.Global.NULL_NUMBER_PLACEHOLDER;
    title: string;
    deployer: string;
    owner: string;
    registrationNumber: string;
    issueTime: number;
    expireTime: number;
    description: string;
    fileName: string;
    fileHash: string;
    status: string = "PENDING";
    estimatePrice: number = Constant.Global.NULL_NUMBER_PLACEHOLDER;
    comment: string = "请耐心等待审核。";
    createTime: number = new Date().getTime();

    //all-args
    constructor(
        title: string,
        deployer: string,
        owner: string,
        registrationNumber: string,
        issueTime: number,
        expireTime: number,
        description: string,
        fileName: string,
        fileHash: string,
    ) {
        this.title = title;
        this.deployer = deployer;
        this.owner = owner;
        this.registrationNumber = registrationNumber;
        this.issueTime = issueTime;
        this.expireTime = expireTime;
        this.description = description;
        this.fileName = fileName;
        this.fileHash = fileHash;
    }
}

export const EmptyPendingRight = () => {
    return new PendingRight(
        Constant.Global.NULL_STRING_PLACEHOLDER,
        Constant.Global.NULL_STRING_PLACEHOLDER,
        Constant.Global.NULL_STRING_PLACEHOLDER,
        Constant.Global.NULL_STRING_PLACEHOLDER,
        Constant.Global.NULL_NUMBER_PLACEHOLDER,
        Constant.Global.NULL_NUMBER_PLACEHOLDER,
        Constant.Global.NULL_STRING_PLACEHOLDER,
        Constant.Global.NULL_STRING_PLACEHOLDER,
        Constant.Global.NULL_STRING_PLACEHOLDER,
    )
}

export default PendingRight