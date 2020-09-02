export function required(v: any): boolean | string {
    return !!v || "Required";
}

