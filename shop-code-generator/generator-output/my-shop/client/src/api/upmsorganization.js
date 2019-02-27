
/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


import fetch from 'utils/fetch';

export function fetchList() {
    return fetch({
        url: '/api/upmsorganization/list',
        method: 'get'
    });
}

export function insertUpmsOrganization(data) {
    return fetch({
        url: '/api/upmsorganization/insert',
        method: 'post',
        data,
    });
}

export function deleteUpmsOrganization(data) {
    return fetch({
        url: '/api/upmsorganization/delete',
        method: 'post',
        data,
    });
}

export function updateUpmsOrganization(data) {
    return fetch({
        url: '/api/upmsorganization/update',
        method: 'post',
        data,
        // headers: {
        //   'Content-type': 'application/x-www-form-urlencoded'
        // }
    });
}