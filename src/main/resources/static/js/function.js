/**
 * 문자열의 마지막(끝) 문자의 종성 포함 여부 확인
 * @param value - Target String
 * @returns 종성 포함 여부
 */
function hasCoda(value) {
    return ((value.charCodeAt(value.length - 1) - 0xAC00) % 28) > 0;
}


/**
 * 필드(Elemenet) 유효성 검사
 * @param target - 검사 대상 Element
 * @param fieldName - 필드명
 * @param focusTarget - 포커스 대상 Element
 * @returns 필드 입력(선택) 여부
 */
function isValid(target, fieldName, focusTarget) {
    if (target.value.trim()) {
        return true;
    }

    const particle = (hasCoda(fieldName)) ? '을' : '를'; // 조사
    const elementType = (target.type === 'text' || target.type === 'password' || target.type === 'search' || target.type === 'textarea') ? '입력' : '선택';
    alert( `${fieldName + particle} ${elementType}해 주세요.` );

    target.value = '';
    ( !focusTarget ? target : focusTarget).focus();
    throw new Error(`"${target.id}" is required...`)
}

/**
 * 00시에 초기화되는 쿠키에 데이터 입력
 * @param name - 저장 데이터 key
 * @param value - 저장 데이터
 * @param 저장일
 * @returns 필드 입력(선택) 여부
 */
function setCookie00(name, value, expiredays) {
    var todayDate = new Date(); todayDate = new Date(parseInt(todayDate.getTime() / 86400000) * 86400000 + 54000000);

    if (todayDate > new Date()) {
        expiredays = expiredays - 1;
    }

    todayDate.setDate(todayDate.getDate() + expiredays);

    document.cookie = name + "=" + escape(value) + "; path=/; expires=" + todayDate.toGMTString() + ";";
}

/**
 * 쿠키 가져오기
 * @param name - 가져올 데이터 key
 * @returns 가져온 쿠키 정보
 */
function getCookie(name) {
    var nameOfCookie = name + "=";
    var x = 0;
    while (x <= document.cookie.length) {
        var y = (x + nameOfCookie.length);

        if (document.cookie.substring(x, y) == nameOfCookie) {
            if ((endOfCookie = document.cookie.indexOf(";", y)) == -1)
                endOfCookie = document.cookie.length;
            return unescape(document.cookie.substring(y, endOfCookie));
        }

        x = document.cookie.indexOf(" ", x) + 1;

        if (x == 0) break;
    }

    return "";
}

/**
 * 접속 단말기 OS 정보 가져오기
 * @returns 접속한 OS 정보
 */
function getOsType(){
    var result = "";
    var userAgentInfo = navigator.userAgent.toLowerCase();
    var osTypeFilter = "mac|win16|win32|win64";

    if(navigator.platform != null){
        if(osTypeFilter.indexOf(navigator.platform.toLowerCase()) > -1){
            result = "pc";
        }else{
            if(userAgentInfo.indexOf("android") > -1){
                result = "android";
            }else if(userAgentInfo.indexOf("iphone") > -1){
                result = "ios";
            }
        }
    }

    return result;
}