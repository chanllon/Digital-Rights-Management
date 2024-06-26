import Constant from "~/constant/Constant.ts";

class RightData {
    index: number;
    title: string;
    deployer: string;
    owner: string;
    registrationNumber: string;
    issueTime: number;
    expireTime: number;
    description: string;
    fileName: string;
    fileHash: string;

    //all-args
    constructor(
        index: number,
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
        this.index = index;
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

export const EmptyRight = () => {
    return new RightData(
        Constant.Global.NULL_NUMBER_PLACEHOLDER,
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

export default RightData